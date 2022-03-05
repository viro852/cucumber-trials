package ru.ibs.appline.framework.managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ibs.appline.framework.pages.MortgageOnFinishedHomesPage;
import ru.ibs.appline.framework.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
    Logger logger = LoggerFactory.getLogger(PageManager.class);
    private StartPage startPage;
    private MortgageOnFinishedHomesPage mortgageOnFinishedHomesPage;

    private PageManager() {

    }

    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgageOnFinishedHomesPage getMortgageOnFinishedHomesPage() {
        if (mortgageOnFinishedHomesPage == null) {
            mortgageOnFinishedHomesPage = new MortgageOnFinishedHomesPage();
        }
        return mortgageOnFinishedHomesPage;
    }
}
