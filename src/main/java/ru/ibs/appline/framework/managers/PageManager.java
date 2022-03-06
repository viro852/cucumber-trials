package ru.ibs.appline.framework.managers;

import ru.ibs.appline.framework.pages.MortgageOnFinishedHomesPage;
import ru.ibs.appline.framework.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
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
        startPage=new StartPage();
        return startPage;
    }

    public MortgageOnFinishedHomesPage getMortgageOnFinishedHomesPage() {
        if (mortgageOnFinishedHomesPage == null) {
            mortgageOnFinishedHomesPage = new MortgageOnFinishedHomesPage();
        }
        return mortgageOnFinishedHomesPage;
    }
}
