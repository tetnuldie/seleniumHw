package org.example.driver;

import org.openqa.selenium.WebDriver;

public class ChromeDriver {
    private static final WebDriver instance;

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        instance = new org.openqa.selenium.chrome.ChromeDriver();
    }

    public static WebDriver getInstance(){
        return instance;
    }


}
