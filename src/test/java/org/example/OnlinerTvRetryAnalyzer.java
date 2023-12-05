package org.example;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class OnlinerTvRetryAnalyzer implements IRetryAnalyzer {
    private int retryCount;

    private final int retryLimit = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < retryLimit){
            retryCount++;
            return true;
        }else{
            return false;
        }
    }
}
