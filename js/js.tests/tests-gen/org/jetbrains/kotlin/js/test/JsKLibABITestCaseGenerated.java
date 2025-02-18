/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateJsTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/klibABI")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class JsKLibABITestCaseGenerated extends AbstractJsKLibABITestCase {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.JS_IR, testDataFilePath);
    }

    public void testAllFilesPresentInKlibABI() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/klibABI"), Pattern.compile("^([^_](.+))$"), null, TargetBackend.JS_IR, false);
    }

    @TestMetadata("removeAbstractFunctionFromAbstractClass")
    public void testRemoveAbstractFunctionFromAbstractClass() throws Exception {
        runTest("compiler/testData/klibABI/removeAbstractFunctionFromAbstractClass/");
    }

    @TestMetadata("removeAbstractFunctionFromInterface")
    public void testRemoveAbstractFunctionFromInterface() throws Exception {
        runTest("compiler/testData/klibABI/removeAbstractFunctionFromInterface/");
    }

    @TestMetadata("removeAbstractPropertyFromAbstractClass")
    public void testRemoveAbstractPropertyFromAbstractClass() throws Exception {
        runTest("compiler/testData/klibABI/removeAbstractPropertyFromAbstractClass/");
    }

    @TestMetadata("removeAbstractPropertyFromInterface")
    public void testRemoveAbstractPropertyFromInterface() throws Exception {
        runTest("compiler/testData/klibABI/removeAbstractPropertyFromInterface/");
    }

    @TestMetadata("removeClassAsConstructorCall")
    public void testRemoveClassAsConstructorCall() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsConstructorCall/");
    }

    @TestMetadata("removeClassAsParameterType")
    public void testRemoveClassAsParameterType() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsParameterType/");
    }

    @TestMetadata("removeClassAsReturnType")
    public void testRemoveClassAsReturnType() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsReturnType/");
    }

    @TestMetadata("removeClassAsSuperTypeArgument")
    public void testRemoveClassAsSuperTypeArgument() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsSuperTypeArgument/");
    }

    @TestMetadata("removeClassAsTypeArgument")
    public void testRemoveClassAsTypeArgument() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsTypeArgument/");
    }

    @TestMetadata("removeClassAsVariableType")
    public void testRemoveClassAsVariableType() throws Exception {
        runTest("compiler/testData/klibABI/removeClassAsVariableType/");
    }

    @TestMetadata("removeFunction")
    public void testRemoveFunction() throws Exception {
        runTest("compiler/testData/klibABI/removeFunction/");
    }

    @TestMetadata("removeInlinedClass")
    public void testRemoveInlinedClass() throws Exception {
        runTest("compiler/testData/klibABI/removeInlinedClass/");
    }

    @TestMetadata("removeInlinedFunction")
    public void testRemoveInlinedFunction() throws Exception {
        runTest("compiler/testData/klibABI/removeInlinedFunction/");
    }

    @TestMetadata("removeInlinedProperty")
    public void testRemoveInlinedProperty() throws Exception {
        runTest("compiler/testData/klibABI/removeInlinedProperty/");
    }

    @TestMetadata("removeOpenFunction")
    public void testRemoveOpenFunction() throws Exception {
        runTest("compiler/testData/klibABI/removeOpenFunction/");
    }

    @TestMetadata("removeOpenProperty")
    public void testRemoveOpenProperty() throws Exception {
        runTest("compiler/testData/klibABI/removeOpenProperty/");
    }

    @TestMetadata("removeProperty")
    public void testRemoveProperty() throws Exception {
        runTest("compiler/testData/klibABI/removeProperty/");
    }

    @TestMetadata("typeAliasRHSTypeChange")
    public void testTypeAliasRHSTypeChange() throws Exception {
        runTest("compiler/testData/klibABI/typeAliasRHSTypeChange/");
    }
}
