package ru.ibs.appline.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageOnFinishedHomesPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),  \"вторичное жильё\") and contains(text(),\"Ипотека\")]")
    private WebElement mortgagePageH1;

    @FindBy(xpath = "//span[contains(text(),'Рассчитать ипо')]")
    private WebElement calculateMortgageButton;

    @FindBy(xpath = "//p[contains(text(),'Калькулятор ипотеки')]")
    private WebElement finishedHomesMortgageCalculatorText;

    @FindBy(xpath = "//input[@aria-label=\"Стоимость недвижимости\"]")
    private WebElement propertyPriceInputField;

    @FindBy(xpath = "//input[@aria-label=\"Первоначальный взнос\"]")
    private WebElement initialPaymentInputField;

    @FindBy(xpath = "//input[@aria-label=\"Срок кредитования\"]")
    private WebElement creditPeriodInputField;

    @FindBy(xpath = "//div[@class=\"aOOAsX fOOAsX nOOAsX a2kwpw\"]/div[1]//label[@class=\"a2Pj2k g2Pj2k j2Pj2k l2Pj2k\"]")
    private WebElement mortgage4FamilyWithChildrenCheckbox;

    @FindBy(xpath = "//p[@class=\"a3IoXD c3IoXD u3IoXD e1AM-T d1AM-T g1AM-T\"]")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//div[@class=\"aANiGw\"]/div[1]//p[@class=\"a2CVaU c2CVaU K2CVaU a2CURt b2CURt\"]")
    private WebElement mortgageRate;

    @FindBy(xpath = "//div[@class=\"aANiGw\"]/div[2]//p[@class=\"a2CVaU c2CVaU K2CVaU a2CURt b2CURt\"]")
    private WebElement creditSum;

    @FindBy(xpath = "//div[@class=\"aANiGw\"]/div[3]//p[@class=\"a2CVaU c2CVaU K2CVaU a2CURt b2CURt\"]")
    private WebElement taxDeduction;


    public MortgageOnFinishedHomesPage checkThatPageIsLoad() {
        wait.until(ExpectedConditions.titleIs("Ипотека на вторичное жилье \uD83C\uDFE0 | Взять ипотеку на вторичку по низкой ставке, оформить заявку онлайн — Альфа\u2060-\u2060Банк"));
        assertEquals("Ипотека на вторичное жилье \uD83C\uDFE0 | Взять ипотеку на вторичку по низкой ставке, оформить заявку онлайн — Альфа\u2060-\u2060Банк", seleniumWebDriver.getTitle(), "Мы не перешли на страницу с ипотекой на вторичное жилье, тайтлы разные");
        return this;
    }

    public MortgageOnFinishedHomesPage clickCalculateMortgageButton() {
        waitUntilElementToBeClickable(calculateMortgageButton).click();

        return this;
    }

    public MortgageOnFinishedHomesPage checkThatMortgageCalculatorTextIsDisplayed() {
        assertTrue(finishedHomesMortgageCalculatorText.isDisplayed());
        assertEquals("Калькулятор ипотеки на вторичное жильё", finishedHomesMortgageCalculatorText.getText());

        return this;
    }

    public MortgageOnFinishedHomesPage fillAllMortgageCalculatorFields(String fieldName, String fieldValue) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement currentInputField = null;
        switch (fieldName) {
            case "Стоимость недвижимости":
                currentInputField = propertyPriceInputField;
                fillInputField(propertyPriceInputField, fieldValue);
                break;
            case "Первоначальный взнос":
                currentInputField = initialPaymentInputField;
                fillInputField(initialPaymentInputField, fieldValue);
                break;
            case "Срок кредитования":
                currentInputField = creditPeriodInputField;
                fillInputField(creditPeriodInputField, fieldValue);
                break;
            default:
                fail("Поля с названием " + fieldName + " не найдено на странице 'Ипотека на вторичное жильё'");
        }
        String cleanedCurrentInputField = currentInputField.getAttribute("value").replace(" ", "");

        assertEquals(fieldValue, cleanedCurrentInputField, "Поле " + fieldName + " было заполнено некорректно ");
        return this;
    }

    private void fillInputField(WebElement element, String value) {

        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(value);
    }

    public void enableMortgage4FamilyWithChildrenCheckbox() {
        waitUntilElementToBeClickable(mortgage4FamilyWithChildrenCheckbox);
        mortgage4FamilyWithChildrenCheckbox.click();
    }

    public void checkCalculatorFieldsByCorrectValues(String fieldName, String correctValue) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement currentField = null;
        switch (fieldName) {
            case "Ежемесячный платёж":
                waitUntilElementToBeVisible(monthlyPayment);
                currentField = monthlyPayment;
                checkFieldValue(fieldName, currentField, correctValue);
                break;
            case "Ставка":
                currentField = mortgageRate;
                checkFieldValue(fieldName, currentField, correctValue);
                break;
            case "Сумма кредита":
                currentField = creditSum;
                checkFieldValue(fieldName, currentField, correctValue);
                break;
            case "Налоговый вычет":
                currentField = taxDeduction;
                checkFieldValue(fieldName, currentField, correctValue);
                break;

            default:
                fail("Поля с названием " + fieldName + " не найдено на странице 'Ипотека на вторичное жильё'");
        }

    }

    private void checkFieldValue(String fieldName, WebElement fieldForCheck, String correctValue) {
        assertEquals(correctValue, fieldForCheck.getText(), "Калькулятор ипотеки на вторичное жилье совершил неверный расчет в поле '" + fieldName + "', ожидали " + correctValue + ", а получили " + fieldForCheck.getText() + "");
    }


}
