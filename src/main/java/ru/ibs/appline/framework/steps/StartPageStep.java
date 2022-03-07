package ru.ibs.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;
import ru.ibs.appline.framework.pages.StartPage;

public class StartPageStep {
   private final PageManager pageManager = PageManager.getInstance();

    @И("Проверяем,что стартовая страница успешно загрузилась")
    public void checkThatPageIsLoad() {
        pageManager.getPage(StartPage.class).checkThatPageIsLoad();
    }

    @И("^В верхнем меню наводим курсор на \'(.+)\'$")
    public void moveTopMenuNeededElement(String topMenuElementName) {
        pageManager.getPage(StartPage.class).moveTopMenuNeededElement(topMenuElementName);
    }

    @И("^В выпадающем меню кликаем на \'(.+)\'$")
    public void clickDropDownMenuToNeededElement(String dropDownMenuElementName) {
        pageManager.getPage(StartPage.class).clickDropDownMenuToNeededElement(dropDownMenuElementName);
    }
}
