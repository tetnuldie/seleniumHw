package org.example.page;

import org.example.driver.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogPO {
    private final String url = "https://catalog.onliner.by/";
    @FindBy(xpath = "//li[@data-id=\"1\"]")
    private WebElement electronics;
    @FindBy(xpath = "//li[@data-id=\"2\"]")
    private WebElement computers;
    @FindBy(xpath = "//li[@data-id=\"3\"]")
    private WebElement agd;
    @FindBy(xpath = "//li[@data-id=\"4\"]")
    private WebElement building;
    @FindBy(xpath = "//li[@data-id=\"5\"]")
    private WebElement household;
    @FindBy(xpath = "//li[@data-id=\"6\"]")
    private WebElement auto;
    @FindBy(xpath = "//li[@data-id=\"7\"]")
    private WebElement beauty;
    @FindBy(xpath = "//li[@data-id=\"8\"]")
    private WebElement children;
    @FindBy(xpath = "//li[@data-id=\"9\"]")
    private WebElement everyday;

    public CatalogPO(){
        PageFactory.initElements(ChromeDriver.getInstance(), this);
    }

    public String getUrl() {
        return url;
    }

    public void openPage(){
        ChromeDriver.getInstance().get(url);
        ChromeDriver.getInstance().manage().window().maximize();
    }

    public WebElement getElectronics() {
        return electronics;
    }

    public WebElement getComputers() {
        return computers;
    }

    public WebElement getAgd() {
        return agd;
    }

    public WebElement getBuilding() {
        return building;
    }

    public WebElement getHousehold() {
        return household;
    }

    public WebElement getAuto() {
        return auto;
    }

    public WebElement getBeauty() {
        return beauty;
    }

    public WebElement getChildren() {
        return children;
    }

    public WebElement getEveryday() {
        return everyday;
    }

    public List<WebElement> getDependentList(String xpath){
        return ChromeDriver.getInstance().findElements(By.xpath(xpath));
    }

    public void passScenario(WebElement element){
        ChromeDriver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        getDependentList(String.format("//div[@data-id=\"%s\"]//div[@class=\"catalog-navigation-list__aside-item\"]", element.getAttribute("data-id"))
        ).stream().forEach(webElement -> {
            ChromeDriver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            getDependentList("//div[@class=\"catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active\"]//a/span/span[@class!=\"catalog-navigation-list__dropdown-preview\"]")
                    .stream().forEach(webElement1 -> {
                        System.out.println(webElement1.getText());

                    });
        });
        element.click();
    }

}
