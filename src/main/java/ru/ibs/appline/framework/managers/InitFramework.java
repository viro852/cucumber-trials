package ru.ibs.appline.framework.managers;

import static ru.ibs.appline.framework.utils.AntiHardcoreConsts.Urls.START_PAGE_URL;

public class InitFramework {

    private static InitFramework initFramework;
    private final WebDriverManager webDriverManager = WebDriverManager.getInstance();
    private PropManager propManager = PropManager.getInstance();


    private InitFramework() {
        webDriverManager.getSeleniumWebDriver();
    }

    public static InitFramework getInstance() {
        if (initFramework == null) {
            initFramework = new InitFramework();
        }
        return initFramework;
    }

    public void startFramework() {
        webDriverManager.getSeleniumWebDriver().get(propManager.getApplicationProperties().getProperty(START_PAGE_URL));
    }

    public void quitFramework() {
        webDriverManager.quitSeleniumWebDriver();
    }
}
