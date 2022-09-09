package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Yeltsin_Open_Wine_Card {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //без всплывающих окон
        options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://yeltsin.ru/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//div[.='Покупки и развлечения']")).click();
        driver.findElement(By.xpath("//label[@for='headerLink-eda-1']")).click();
        driver.findElement(By.xpath("//a[@href='/platform/barboris/']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Контакты']")));
        driver.findElement(By.xpath("//div[.='Контакты']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[.='Винная карта (2021)']")));
        driver.findElement(By.xpath("//div[.='Винная карта (2021)']")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
