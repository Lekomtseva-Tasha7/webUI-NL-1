package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Eldorado {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-notifications"); //без всплывающих окон
        //firefoxOptions.addPreference("general.useragent.override","Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("https://www.eldorado.ru");
        driver.findElement(By.xpath("//button[.='Да, верно']")).click(); // всплывает и закрывает поле ввода
        WebElement elementInput = driver.findElement(By.xpath("//input[@aria-label='Поиск товаров']"));
        elementInput.sendKeys("смартфон");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Смартфоны' and @class='AH']"))); // не показывается саджест
        //driver.findElement(By.xpath("//a[.='Смартфоны' and @type='button']")).click();
        driver.findElement(By.xpath("//button[.='Найти']"));

        Thread.sleep(7000);
        driver.close();
    }
}
