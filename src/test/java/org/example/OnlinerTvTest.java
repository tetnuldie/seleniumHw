package org.example;

import org.example.driver.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

@Listeners(OnlinerTvListener.class)
public class OnlinerTvTest {
    private WebDriver wDriver = ChromeDriver.getInstance();


    @AfterTest
    public void quitDriver() {
        wDriver.quit();
    }

    @Test(testName = "Test TV list match manufacturer' filter ",
            groups = {"tvTest"},
            priority = 1,
            dataProvider = "manufacturersProvider",
            retryAnalyzer = OnlinerTvRetryAnalyzer.class)
    public void onlinerTvTest(String url, String manufacturersName) {
        wDriver.get(url);
        wDriver.manage().window().fullscreen();
        Actions actions = new Actions(wDriver);

        By checkboxBy = By.xpath(String.format("//*[@id=\"schema-filter\"]//div[@class=\"schema-filter__facet\"]" +
                "/ul/li/label[@class=\"schema-filter__checkbox-item\"]" +
                "/span[@class=\"i-checkbox\"]/input[@type=\"checkbox\" and @value=\"%s\"]", manufacturersName));

        WebElement checkbox = wDriver.findElement(checkboxBy);

        actions.moveToElement(checkbox);
        actions.click();
        actions.perform();

        Wait<WebDriver> wait = new FluentWait<>(wDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.urlContains(String.format("%s", manufacturersName)));

        By by = By.xpath("//div[@id=\"schema-products\"]//div[@class=\"schema-product__title\"]/a/span");

        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        list.stream().forEach(element -> {
            assertTrue(element.getText().toLowerCase().contains(manufacturersName));
        });
    }

    @DataProvider(name = "manufacturersProvider")
    public Object[][] manufacturersProvider() {
        return new Object[][]{
                {"https://catalog.onliner.by/tv/", "lg"},
                {"https://catalog.onliner.by/tv/", "sony"},
                {"https://catalog.onliner.by/tv/", "philips"}
        };
    }
}
