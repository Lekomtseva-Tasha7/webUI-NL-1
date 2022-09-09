package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless"); // окно-невидимка, чтобы не намахать мышкой поломку теста
        chromeOptions.addArguments("--disable-notifications"); //без всплывающих окон
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)"); // запуск от имени автобота

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");

        Thread.sleep(5000);
        driver.quit();
    }
}
