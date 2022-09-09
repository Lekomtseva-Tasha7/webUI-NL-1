package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ozon {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //без всплывающих окон
        //options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)"); // ботов тут не пускают

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("https://www.ozon.ru");
        WebElement elementInput = driver.findElement(By.xpath("//input[@placeholder='Искать на Ozon']"));
        elementInput.sendKeys("гречка");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[.='Гречка']")));
        driver.findElement(By.xpath("//strong[.='Гречка']")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
