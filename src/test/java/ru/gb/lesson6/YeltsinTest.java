package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.gb.lesson6.homework6.MuseumPage;

public class YeltsinTest {
    WebDriver driver;
    MuseumPage museumPage;

    @BeforeAll
    static void registerDriver () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver (){
        driver = new ChromeDriver();
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
       driver.quit();
    }
}
