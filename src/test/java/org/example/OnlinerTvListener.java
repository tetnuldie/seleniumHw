package org.example;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class OnlinerTvListener implements ITestListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        System.out.println("Params:");
        Object[] params = result.getParameters();
        for (Object o : params) {
            System.out.println(o.toString());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        System.out.println("Params:");
        Object[] params = result.getParameters();
        for (Object o : params) {
            System.out.println(o.toString());
        }
    }


}
