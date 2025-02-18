/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("PackageDirectoryMismatch") // Old package for compatibility
package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.jetbrains.kotlin.gradle.dsl.CompilerJvmOptions
import org.jetbrains.kotlin.gradle.dsl.CompilerJvmOptionsDefault
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.*
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinTasksProvider
import org.jetbrains.kotlin.gradle.utils.SingleWarningPerBuild

class KotlinJvmWithJavaTargetPreset(
    private val project: Project
) : KotlinTargetPreset<KotlinWithJavaTarget<KotlinJvmOptions, CompilerJvmOptions>> {

    override fun getName(): String = PRESET_NAME

    override fun createTarget(name: String): KotlinWithJavaTarget<KotlinJvmOptions, CompilerJvmOptions> {
        SingleWarningPerBuild.show(
            project,
            DEPRECATION_WARNING
        )

        project.plugins.apply(JavaPlugin::class.java)

        @Suppress("UNCHECKED_CAST", "DEPRECATION")
        val target = (project.objects.newInstance(
            KotlinWithJavaTarget::class.java,
            project,
            KotlinPlatformType.jvm,
            name,
            {
                object : HasCompilerOptions<CompilerJvmOptions> {
                    override val options: CompilerJvmOptions =
                        project.objects.newInstance(CompilerJvmOptionsDefault::class.java)
                }
            },
            { compilerOptions: CompilerJvmOptions ->
                object : KotlinJvmOptions {
                    override val options: CompilerJvmOptions
                        get() = compilerOptions
                }
            }
        ) as KotlinWithJavaTarget<KotlinJvmOptions, CompilerJvmOptions>)
            .apply {
                disambiguationClassifier = name
                preset = this@KotlinJvmWithJavaTargetPreset
            }

        AbstractKotlinPlugin.configureTarget(target) { compilation ->
            Kotlin2JvmSourceSetProcessor(KotlinTasksProvider(), compilation)
        }

        target.compilations.getByName("test").run {
            val main = target.compilations.getByName(KotlinCompilation.MAIN_COMPILATION_NAME)

            compileDependencyFiles = project.files(
                main.output.allOutputs,
                project.configurations.maybeCreate(compileDependencyConfigurationName)
            )
            runtimeDependencyFiles = project.files(
                output.allOutputs,
                main.output.allOutputs,
                project.configurations.maybeCreate(runtimeDependencyConfigurationName)
            )
        }

        return target
    }

    companion object {
        const val PRESET_NAME = "jvmWithJava"

        val DEPRECATION_WARNING = "\nThe 'jvmWithJava' preset is deprecated and will be removed soon. " +
                "Please use an ordinary JVM target with Java support: \n\n" +
                "    kotlin { \n" +
                "        jvm { \n" +
                "            ${KotlinJvmTarget::withJava.name}() \n" +
                "        } \n" +
                "    }\n\n" +
                "After this change, please move the Java sources to the Kotlin source set directories. " +
                "For example, if the JVM target is given the default name 'jvm':\n" +
                " * instead of 'src/main/java', use 'src/jvmMain/java'\n" +
                " * instead of 'src/test/java', use 'src/jvmTest/java'\n"
    }
}
