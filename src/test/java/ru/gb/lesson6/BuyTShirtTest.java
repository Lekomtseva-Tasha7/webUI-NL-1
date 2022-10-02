package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyTShirtTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver (){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void buyTShortTest (){
        mainPage.clickSingInButton()
                .login("spartalex93@test.test", "123456")
                .navigationBlock.hoverWomenMenuAndClickTShirts()
                .selectSize("S")
                .moveLeftPriceSliderElement(10)
                .addToCartByName("Faded")
                .checkTotalSumma("$18.51");
    }

    @AfterEach
    void terDown (){
        driver.quit();
    }
}

