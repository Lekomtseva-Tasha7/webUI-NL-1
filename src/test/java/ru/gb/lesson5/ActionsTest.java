package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ActionsTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver (){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @Test
    @DisplayName("Наведение курсора и протяжка по 3 символам вправо")
    void highlightTextTest () throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1200, 1200)); // Задать размер экрана
        driver.get("https://translate.google.com/?sl=en&tl=ru&text=test&op=translate");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@aria-label='Исходный текст']//following-sibling::div//span")));
        actions.moveToElement(driver.findElement(By.xpath("//textarea[@aria-label='Исходный текст']//following-sibling::div//span")),-20, 0)
                .clickAndHold()
                .moveByOffset(30, 0)
                .perform();

        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Работа с аллертами")
    void yetNewExamples () throws InterruptedException {
        driver.get("https://www.google.com");
        ((JavascriptExecutor)driver).executeScript("alert('fghfghdhj')");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB); //Открываем новую вкладку
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // переходим в только что открытое окно
        driver.get("https://www.ya.ru"); // открываем новую вкладку в этом окне
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        driver.close();
    }

    @AfterEach
    void tearDown () {
        driver.quit();
    }
}
