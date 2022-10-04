package ru.gb.lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;


public class AdditionalLogger implements WebDriverListener {
    public void beforeFindElements(WebDriver driver, By locator) {
        Allure.step("Ищем элемент по локатору: " + locator);
    }

    public void beforeQuit(WebDriver driver) {
        //Allure.addAttachment("Скриншот перед закрытием браузера",
        //new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}
