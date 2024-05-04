package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver lDriver)
    {
        this.driver=lDriver;

        PageFactory.initElements(driver,this);

    }
    @FindBy(id="user-name")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login-button")
    WebElement loginButton;

    public void loginIn(String username, String password)
    {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }



}
