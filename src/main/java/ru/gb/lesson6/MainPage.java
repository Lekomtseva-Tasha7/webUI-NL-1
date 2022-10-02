package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BaseView {

    @FindBy(xpath = "//a[@class='login']")
    public WebElement singInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSingInButton (){
        singInButton.click();
        return new LoginPage(driver);
    }
}
