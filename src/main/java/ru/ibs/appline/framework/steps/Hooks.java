package ru.ibs.appline.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.appline.framework.managers.InitFramework;
import ru.ibs.appline.framework.managers.WebDriverManager;

import java.io.ByteArrayInputStream;

public class Hooks {

    private final WebDriverManager webDriverManager = WebDriverManager.getInstance();
    private InitFramework initFramework = InitFramework.getInstance();

    @Before
    public void before() {
        initFramework.startFramework();
    }

    @After
    public void after(Scenario scenario) {
        takeScreenShot(scenario);
        initFramework.quitFramework();
    }

    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) webDriverManager.getSeleniumWebDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
