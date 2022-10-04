package ru.gb.lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import ru.gb.lesson6.homework6.MuseumPage;

import java.io.ByteArrayInputStream;

@Story("Ельцин-центр")
public class YeltsinTestAllureAndLog {
    WebDriver driver;
    MuseumPage museumPage;

    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();

    @BeforeAll
    static void registerDriver () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver (){
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://yeltsin.ru/museum/");
        museumPage = new MuseumPage(driver);
    }

    @Test
    @Feature("Yeltsin - добавление товара в избранное")
    void yeltsinAddItemTest () {
        museumPage.clickOnlineStoreButton()
                .addFavorite()
                .checkAddFavorites();
    }

    @Test
    @Feature("Yeltsin - появление каунтера в избранном")
    void yeltsinChangeCounter() {
        museumPage.clickOnlineStoreButton()
                .addCounter()
                .checkCounter();
    }

    @Test
    @Feature("Yeltsin - добавление билета в корзину")
    void yeltsinAddItem() {
        museumPage.clickBuyTicketButton()
                .checkBuyTicket();
    }

    @AfterEach
    void terDown(){
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            Allure.addAttachment("Лог браузера", log.getMessage());
        }
        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
