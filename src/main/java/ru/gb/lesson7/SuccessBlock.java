package ru.gb.lesson7;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessBlock extends BasePage{

    private final static String favoriteButtonXpathLocator = "//span[.='Удалить все']";
    @FindBy(xpath = favoriteButtonXpathLocator)
    private WebElement textDelete;

    private final static String favoriteCounterXpathLocator = "//span[@class='counter']/span[.='1']";
    @FindBy(xpath = favoriteCounterXpathLocator)
    private WebElement favoriteCounter;

    @FindBy(xpath = "//button//span[.='1 билет']")
    private WebElement ticket;

    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка наличия товара на странице избранного")
    public void checkAddFavorites(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(favoriteButtonXpathLocator)));
        Assertions.assertTrue((textDelete).isDisplayed());
    }

    @Step("Проверка отображения каунтера")
    public void checkCounter(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(favoriteCounter));
        Assertions.assertEquals("1", favoriteCounter.getText());
    }

    @Step("Проверка наличия билета в корзине")
    public void checkBuyTicket(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ticket));
        Assertions.assertTrue((ticket).isDisplayed());
    }
}
