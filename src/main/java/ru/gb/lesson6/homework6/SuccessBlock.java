package ru.gb.lesson6.homework6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessBlock extends BasePage {
    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    private final static String favoriteButtonXpathLocator = "//span[.='Удалить все']";
    @FindBy(xpath = favoriteButtonXpathLocator)
    private WebElement textDelete;

    private final static String favoriteCounterXpathLocator = "//span[@class='counter']/span[.='1']";
    @FindBy(xpath = favoriteCounterXpathLocator)
    private WebElement favoriteCounter;

    @FindBy(xpath = "//button//span[.='1 билет']")
    private WebElement ticket;

    public void checkAddFavorites(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(favoriteButtonXpathLocator)));
        Assertions.assertTrue((textDelete).isDisplayed());
    }

    public void checkCounter(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(favoriteCounter));
        Assertions.assertEquals("1", favoriteCounter.getText());
    }

    public void checkBuyTicket(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ticket));
        Assertions.assertTrue((ticket).isDisplayed());
    }
}
