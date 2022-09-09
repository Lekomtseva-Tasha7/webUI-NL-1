package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Yeltsin_Add_Item {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //без всплывающих окон
        options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // разворачивает окно браузера на весь экран
        driver.get("https://yeltsin.ru/museum/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//span[.='КУПИТЬ БИЛЕТ']")).click();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Завтра 10:00']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Завтра 10:00']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Полный в музей (взрослый) с 10:00 - 21:00']/parent::div/parent::div//button")));
        driver.findElement(By.xpath("//div[.='Полный в музей (взрослый) с 10:00 - 21:00']/parent::div/parent::div//button")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
