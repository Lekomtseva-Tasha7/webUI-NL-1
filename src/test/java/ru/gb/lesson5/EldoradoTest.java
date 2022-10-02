package ru.gb.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EldoradoTest extends BaseTest{

    @BeforeEach
    void openBrowser(){
        driver.get("https://www.eldorado.ru");
    }

    @Test
    @DisplayName("Eldorado - переход на страницу выбраного типа товаров через саджест")
    void openThroughSadgest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@name='search']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='searchHints']//a[.='Стиральные машины']")));
        driver.findElement(By.xpath("//div[@data-test-id='searchHints']//a[.='Стиральные машины']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("stiralnye-mashiny"));
    }

    @Test
    @DisplayName("Eldorado - переход на страницу выбранного типа товаров через заполнение строки поиска и просмотра всех результатов")
    void openThroughInput () throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Да, верно']")));
        driver.findElement(By.xpath("//button[.='Да, верно']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("смартфон");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='searchHints']//a[.='Смартфоны']")));
        driver.findElement(By.xpath("//button[.='Смотреть все результаты']")).click();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Смартфоны']")));
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("smartfony"));
    }

    @Test
    @DisplayName("Eldorado - открытие окна 'Онлайн чат'")
    void openDialogWindow () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Открыть онлайн-консультант' and preceding-sibling::a]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@aria-label='Открыть онлайн-консультант' and preceding-sibling::a]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Онлайн чат']")));
        driver.findElement(By.xpath("//span[.='Онлайн чат']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='__threadswidget_chat__iframe']")));
        driver.switchTo().frame(driver.findElement(By.id("__threadswidget_chat__iframe")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Ваше сообщение...']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//textarea[@placeholder='Ваше сообщение...']")).isDisplayed());
    }
}
