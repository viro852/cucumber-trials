package ru.ibs.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;

import java.util.Map;

public class MortgageOnFinishedHomesStep {
    private final PageManager pageManager = PageManager.getInstance();

    @И("Проверяем,что страница с ипотекой на вторичное жильё успешно загрузилась")
    public void checkThatPageIsLoad() {
        pageManager.getMortgageOnFinishedHomesPage().checkThatPageIsLoad();
    }


    @И("Кликаем на кнопку 'Рассчитать ипотеку'")
    public void clickCalculateMortgageButton() {
        pageManager.getMortgageOnFinishedHomesPage().clickCalculateMortgageButton();
    }

    @И("Проверяем,что спустились к 'Калькулятор ипотеки на вторичное жилье'")
    public void checkThatMortgageCalculatorTextIsDisplayed() {
        pageManager.getMortgageOnFinishedHomesPage().checkThatMortgageCalculatorTextIsDisplayed();
    }

    @И("^Заполняем поля калькулятора для расчета ипотеки на вторичное жилье:$")
    public void fillAllMortgageCalculatorFields(DataTable mapFieldAndValue) {
        Map<Object, Object> mortgageCalculatorFieldNameAndFieldValueMap = mapFieldAndValue.asMap(String.class, String.class);
        mortgageCalculatorFieldNameAndFieldValueMap.forEach((key, value) -> pageManager.getMortgageOnFinishedHomesPage().fillAllMortgageCalculatorFields((String) key, (String) value));

    }

    @И("^Ставим галочку 'Ипотека для семей с детьми'$")
    public void enableMortgage4FamilyWithChildrenCheckbox() {
        pageManager.getMortgageOnFinishedHomesPage().enableMortgage4FamilyWithChildrenCheckbox();
    }

    @И("^Проверяем правильность расчетов калькулятора ипотеки на вторичное жилье:$")
    public void checkCalculatorFieldsByCorrectValues(DataTable dataTable) {
        dataTable.asMap(String.class, String.class).forEach((k, v) -> pageManager.getMortgageOnFinishedHomesPage().checkCalculatorFieldsByCorrectValues((String) k, (String) v));
    }


}
