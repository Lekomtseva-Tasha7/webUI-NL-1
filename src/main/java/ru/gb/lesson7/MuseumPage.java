package ru.gb.lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MuseumPage extends BasePage{
    @FindBy(xpath = "//a[.='Интернет-магазин музейных сувениров ']")
    private WebElement onlineStoreButton;

    @FindBy(xpath = "//span[.='КУПИТЬ БИЛЕТ']")
    private WebElement buyTicketButton;

    @FindBy(id = "frame_afishaWidgetContainer")
    private WebElement afishaWidget;

    @FindBy(xpath = "//button[.='Сегодня 10:00']")
    private WebElement todayButton;

    @FindBy(xpath = "//div[.='Полный в музей (взрослый) с 10:00 - 21:00']/parent::div/parent::div//button")
    private WebElement fullTicketButton;

    public MuseumPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на ссылке интернет-магазина сувениров")
    public CatalogSouvenirsPage clickOnlineStoreButton(){
        onlineStoreButton.click();
        return new CatalogSouvenirsPage(driver);
    }

    @Step("Положить билет в музей в корзину")
    public SuccessBlock clickBuyTicketButton (){
        buyTicketButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(afishaWidget));
        driver.switchTo().frame(afishaWidget);
        webDriverWait.until(ExpectedConditions.visibilityOf(todayButton));
        todayButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(fullTicketButton));
        fullTicketButton.click();
        return new SuccessBlock(driver);
    }
}
