package ru.ibs.appline.framework.pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//span[@class=\"q1Cda9\"][4]//div[@class=\"r1Cda9\"]/div//a")
    List<WebElement> dropDownMenu;
    @FindBy(xpath = "//span[@class=\"q1Cda9\"]")
    private List<WebElement> topMenuElementsList;

    public StartPage checkThatPageIsLoad() {
        wait.until(ExpectedConditions.titleIs("Альфа-Банк - кредитные и дебетовые карты, кредиты наличными, автокредитование, ипотека и другие банковские услуги физическим и юридическим лицам – Альфа-Банк"));
        Assertions.assertEquals("Альфа-Банк - кредитные и дебетовые карты, кредиты наличными, автокредитование, ипотека и другие банковские услуги физическим и юридическим лицам – Альфа-Банк", seleniumWebDriver.getTitle(), "Мы не перешли на стартовую страницу");
        return this;
    }

    public StartPage moveTopMenuNeededElement(String topMenuElementName) {
        Actions actions = new Actions(seleniumWebDriver);
        for (WebElement topMenuElement : topMenuElementsList) {
            if (topMenuElement.findElement(By.xpath(".//a")).getAttribute("title").contains(topMenuElementName)) {
                actions.moveToElement(topMenuElement).perform();
                return this;
            }
        }
        Assertions.fail("Не удалось найти переданный элемент в верхнем меню стартовой страницы");
        return this;
    }

    public MortgageOnFinishedHomesPage clickDropDownMenuToNeededElement(String dropDownMenuElementName) {
        for (WebElement dropDownMenuElement : dropDownMenu) {
            if (dropDownMenuElement.getAttribute("title").contains(dropDownMenuElementName)) {
                System.out.println("нужный элемент выпадающего меню найден");
                waitUntilElementToBeClickable(dropDownMenuElement);
                dropDownMenuElement.click();
                return pageManager.getMortgageOnFinishedHomesPage();
            }
            System.out.println("поиск нужного элемента");
        }
        Assert.fail("не удалось найти переданный элемент в выпадающем меню стартовой страницы");
        return pageManager.getMortgageOnFinishedHomesPage();
    }

}
