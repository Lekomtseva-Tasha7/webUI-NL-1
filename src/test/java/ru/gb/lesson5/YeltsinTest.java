package ru.gb.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YeltsinTest extends BaseTest {

    @Test
    @DisplayName("Yeltsin - открытие винной карты")
    void yeltsinOpenWineCard() {
        driver.get("https://yeltsin.ru/");
        driver.findElement(By.xpath("//div[.='Покупки и развлечения']")).click();
        driver.findElement(By.xpath("//label[@for='headerLink-eda-1']")).click();
        driver.findElement(By.xpath("//a[@href='/platform/barboris/']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Контакты']")));
        driver.findElement(By.xpath("//div[.='Контакты']")).click();
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//div[.='Винная карта (2021)']"))).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[.='Винная карта (2021)']")));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Vin-karta"));
    }

    @Test
    @DisplayName("Yeltsin - добавление билета в корзину")
    void yeltsinAddItem() {
        driver.get("https://yeltsin.ru/museum/");
        driver.findElement(By.xpath("//span[.='КУПИТЬ БИЛЕТ']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame_afishaWidgetContainer")));
        driver.switchTo().frame(driver.findElement(By.id("frame_afishaWidgetContainer")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Сегодня 10:00']")));
        driver.findElement(By.xpath("//button[.='Сегодня 10:00']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Полный в музей (взрослый) с 10:00 - 21:00']/parent::div/parent::div//button")));
        driver.findElement(By.xpath("//div[.='Полный в музей (взрослый) с 10:00 - 21:00']/parent::div/parent::div//button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[.='1 билет']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//button//span[.='1 билет']")).isDisplayed());
    }

    @Test
    @DisplayName("Yeltsin - появление каунтера в избранном")
    void yeltsinChangeCounter() {
        driver.get("https://piotrovsky.store/catalog/souvenirs/?utm_source=YC_piotrovsky_museum&utm_medium=SaitYC&utm_campaign=YC");
        driver.findElement(By.xpath("//button[.='Принять']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")));
        driver.findElement(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter']/span[.='1']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class='counter']/span[.='1']")).isDisplayed());
    }

    @Test
    @DisplayName("Yeltsin - добавление товара в избранное")
    void yeltsinAddToFavorites() {
        driver.get("https://yeltsin.ru/museum/");
        driver.findElement(By.xpath("//a[.='Интернет-магазин музейных сувениров ']")).click();
        driver.findElement(By.xpath("//button[.='Принять']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")));
        driver.findElement(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter']/span[.='1']")));
        driver.findElement(By.xpath("//span[@class='counter']/span[.='1']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//span[.='Удалить все']")).isDisplayed());
    }
}
