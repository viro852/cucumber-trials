package ru.ibs.appline.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.ibs.appline.framework.managers.WebDriverManager;

import java.io.ByteArrayInputStream;

public class Hooks {

    WebDriverManager webDriverManager = WebDriverManager.getInstance();

    @Before
    public void before() {
        WebDriver seleniumWebDriver = webDriverManager.getSeleniumWebDriver();
        seleniumWebDriver.get("https://alfabank.ru/");
    }

    @After
    public void TakeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) webDriverManager.getSeleniumWebDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        webDriverManager.quitSeleniumWebDriver();
    }


}
