package ru.ibs.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ibs.appline.framework.pages.StartPage;

import java.util.concurrent.TimeUnit;

import static ru.ibs.appline.framework.utils.AntiHardcoreConsts.CurrentDriver.BROWSER_TYPE;
import static ru.ibs.appline.framework.utils.AntiHardcoreConsts.Paths.CHROME_DRIVER_PATH;
import static ru.ibs.appline.framework.utils.AntiHardcoreConsts.Paths.MOZILLA_DRIVER_PATH;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private final Logger LOGGER = LoggerFactory.getLogger(PageManager.class);
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
        switch (BROWSER_TYPE) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                seleniumWebDriver = new ChromeDriver();
                break;
            }
            case "mozilla": {
                System.setProperty("webdriver.gecko.driver", MOZILLA_DRIVER_PATH);
                seleniumWebDriver = new FirefoxDriver();
                break;
            }
            default:
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                seleniumWebDriver = new ChromeDriver();
        }
        seleniumWebDriver.manage().window().maximize();
        seleniumWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        seleniumWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    public void quitSeleniumWebDriver() {
        if (seleniumWebDriver != null) {
            LOGGER.info("Селениум драйвер " + seleniumWebDriver + " жив и полон сил");
            seleniumWebDriver.quit();
            LOGGER.info("Селениум драйвер " + seleniumWebDriver + " потушили, теперь он пустышка и ничего не может");
            seleniumWebDriver = null;
            LOGGER.info("Теперь даже объекта селениум драйвер не существует т.к. ссылка на него =" + seleniumWebDriver + "");
            PageManager.getInstance().cleanPagesBox();
        }
    }

}
