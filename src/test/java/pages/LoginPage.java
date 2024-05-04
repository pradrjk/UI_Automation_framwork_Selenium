package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver lDriver)
    {
        this.driver=lDriver;

        PageFactory.initElements(driver,this);
    }
}
