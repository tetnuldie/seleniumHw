package org.example.page;

import org.example.driver.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogItemPO {
    @FindBy(xpath = "//*[@class=\"catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active\"]" +
            "/div[@class=\"catalog-navigation-list__aside-title\"]")
    private WebElement activeElementTitle;
    @FindBy(xpath = "//*[@class=\"catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active\"]" +
            "/div[@class=\"catalog-navigation-list__dropdown\"]" +
            "/div/a/span/span[@class=\"catalog-navigation-list__dropdown-title\"]")
    private List<WebElement> itemNames;
    @FindBy(xpath = "//*[@class=\"catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active\"]" +
            "/div[@class=\"catalog-navigation-list__dropdown\"]" +
            "/div/a/span/span[@class=\"catalog-navigation-list__dropdown-description\"]")
    private List<WebElement> itemDescr;

    public CatalogItemPO(){
        PageFactory.initElements(ChromeDriver.getInstance(), this);
    }


    public WebElement getActiveElementTitle() {
        return activeElementTitle;
    }



}
