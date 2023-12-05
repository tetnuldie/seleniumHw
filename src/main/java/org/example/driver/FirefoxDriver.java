package org.example.driver;

import org.openqa.selenium.WebDriver;

public class FirefoxDriver {
    private static final WebDriver instance;

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        instance = new org.openqa.selenium.firefox.FirefoxDriver();
    }

    public static WebDriver getInstance(){
        return instance;
    }
}
