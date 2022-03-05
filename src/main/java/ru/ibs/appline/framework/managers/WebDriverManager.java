package ru.ibs.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver seleniumWebDriver;

    private WebDriverManager() {

    }

    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public WebDriver getSeleniumWebDriver() {
        if (seleniumWebDriver == null) {
            initSeleniumWebDriver();
        }
        return seleniumWebDriver;
    }

    private void initSeleniumWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        seleniumWebDriver = new ChromeDriver();
        seleniumWebDriver.manage().window().maximize();
        seleniumWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        seleniumWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void quitSeleniumWebDriver() {
        if (seleniumWebDriver != null) {
            System.out.println("Селениум драйвер " + seleniumWebDriver + " жив и полон сил");
            seleniumWebDriver.quit();
            System.out.println("Селениум драйвер " + seleniumWebDriver + " потушили, теперь он пустышка и ничего не может");
            seleniumWebDriver = null;
            System.out.println("Теперь даже объекта селениум драйвер не существует т.к. ссылка на него =" + seleniumWebDriver + "");
        }
    }

}
