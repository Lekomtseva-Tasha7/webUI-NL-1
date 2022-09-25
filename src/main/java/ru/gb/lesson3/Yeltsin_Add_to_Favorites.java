package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Yeltsin_Add_to_Favorites {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //без всплывающих окон
        options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://yeltsin.ru/museum/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[.='Интернет-магазин музейных сувениров ']")).click();
        Thread.sleep(3000);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Принять']")));
        driver.findElement(By.xpath("//button[.='Принять']")).click();
        //driver.switchTo().activeElement().click();
        Thread.sleep(3000);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")));
        driver.findElement(By.xpath("//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]")).click();
        driver.findElement(By.xpath("//a[@href='/personal/favorites/']/parent::div//descendant::button")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
