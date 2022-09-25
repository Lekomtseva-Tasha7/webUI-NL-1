package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll // Зарегистрировали chromedriver
    static void registerDriver (){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach // Инициироали все поля
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://afisha.ru");
    }

    @Test
    @DisplayName("Переход на okko по скрывающемуся саджесту")
    void goToOkkoTest () throws InterruptedException {
        //div[@data-test='HONEY-AD AD-ad_1']   локатор рекламы которую надо убрать
        // Приводим driver к формату JS и добавляем скрипт удаления элемента по xpath локатору
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[@data-test='HONEY-AD AD-ad_1']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        //Thread.sleep(5000); //на этом у меня почему-то падает

        // JS для клика на элемент под любыми баннерами
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("gbqfd")));

        // пример скрола до объекта
        actions.scrollToElement(driver.findElement(By.xpath("//button[.='Подписаться']")))
                .perform();
        Thread.sleep(5000);

        //Наведение кнопки мыши на элемент
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .perform(); //обязательный элемент в конце цепочки действий

        //Ставим дебаг чтобы остановить скрытие выпадающего меню и находим локатор строки
        driver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Скоро онлайн в Okko']")).click();

        //Проверяем открылась ли страница при клике на меню
        Assertions.assertTrue(driver.getCurrentUrl().contains("okko"));
    }

    @Test
    @DisplayName("Тест авторизации на Афише")
    void authTest (){
        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("spartalex1993");
        driver.findElement(By.id("password")).sendKeys("Test4test");
        webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@rambler.ru"));
        driver.findElement(By.xpath("//button[.='Войти']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header//a//div[contains(.,'Избранное') and preceding-sibling::span]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//header//a//div[contains(.,'Избранное') and preceding-sibling::span]")).isDisplayed());
    }

    @AfterEach // killBrowser
    void tearDown (){
        driver.quit();
    }
}
