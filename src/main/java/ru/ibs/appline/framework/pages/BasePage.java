package ru.ibs.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.managers.PageManager;
import ru.ibs.appline.framework.managers.WebDriverManager;

public class BasePage {
    WebDriver seleniumWebDriver = WebDriverManager.getInstance().getSeleniumWebDriver();
    WebDriverWait wait = new WebDriverWait(seleniumWebDriver, 20);
    PageManager pageManager = PageManager.getInstance();

    public BasePage() {
        PageFactory.initElements(seleniumWebDriver, this);
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement checkElementByXPath(By xPath) {
        return seleniumWebDriver.findElement(xPath);
    }
}
