package org.example;


import org.example.driver.ChromeDriver;
import org.example.page.CatalogPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class App {
    public static void main(String[] args) {

        WebDriver driver = ChromeDriver.getInstance();
        WebDriverWait wait = ChromeDriver.getWaitInstance();

        CatalogPO page = new CatalogPO();

        page.openPage();

        page.passScenario(page.getElectronics());
        page.passScenario(page.getComputers());
        page.passScenario(page.getAgd());
        page.passScenario(page.getBeauty());
        page.passScenario(page.getAuto());
        page.passScenario(page.getBuilding());
        page.passScenario(page.getChildren());
        page.passScenario(page.getHousehold());
        page.passScenario(page.getEveryday());

        driver.quit();

    }
}
