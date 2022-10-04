package ru.gb.lesson6.homework6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogSouvenirsPage extends BasePage{

    public CatalogSouvenirsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Принять']")
    private WebElement acceptButton;

    private final static String choiceFavoriteXpathLocator = "//article[@data-product-id='18648']//descendant::button[contains(@class,'favorites')]";
    @FindBy(xpath = choiceFavoriteXpathLocator)
    private WebElement choiceFavorite;

    private final static String favoriteCounterXpathLocator = "//span[@class='counter']/span[.='1']";
    @FindBy(xpath = favoriteCounterXpathLocator)
    private WebElement favoriteCounter;

    @Step("Добавление в избранное и переход на страницу избранного")
    public SuccessBlock addFavorite() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choiceFavorite));
        choiceFavorite.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(favoriteCounter));
        favoriteCounter.click();
        return new SuccessBlock(driver);
    }

    @Step("Добавление в избранное")
    public SuccessBlock addCounter(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choiceFavorite));
        choiceFavorite.click();
        return new SuccessBlock(driver);
    }
}
