package pages;

import baseClass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver lDriver)
    {
        this.driver=lDriver;

        PageFactory.initElements(driver,this);

    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Wait up to 10 seconds

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement AddtoCartBtn1Item;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement ShoppingCartButton;



    public void AddItemToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(AddtoCartBtn1Item));
        AddtoCartBtn1Item.click();


    }


}
