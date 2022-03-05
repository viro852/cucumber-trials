package ru.ibs.appline.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenario",
        glue = "ru.ibs.appline.framework.steps",
        tags = "@mortgage",
        plugin = "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm")
public class RunCucumberTest {

}
