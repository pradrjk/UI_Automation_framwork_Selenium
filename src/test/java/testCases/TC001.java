package testCases;

import baseClass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TC001 extends BaseTest {

    @Test(priority =1)
    public void verifyLogin() throws IOException {
        LoginPage lp = new LoginPage(driver);
        String uname = config.getUsername();
        String pwd = config.getPassword();

        lp.loginIn(uname, pwd);

        if(uname.equals("standard_user") && pwd.equals("secret_sauce"))
        {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
        }
        else
        {
            captureScreenShot(driver,"VerifyLogin");
            Assert.fail();
        }



    }
    @Test(priority =2)
    public void fetchDashboardText() throws IOException
    {

        String dashboardTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        String actualTitle= "Swag Labs";

        if(actualTitle.equals(dashboardTitle))
        {
            System.out.println("Test Passed");
        }
        else{
            captureScreenShot(driver,"fetchDashboardText");

        }
        assertEquals(dashboardTitle , actualTitle);

    }

    @Test(priority = 3)
    public void addItemToCart() throws InterruptedException, IOException {

        HomePage hp = new HomePage(driver);
        hp.AddItemToCart();

        WebElement ShoppingCartWithItem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));

        int ItemCount = Integer.parseInt(ShoppingCartWithItem.getText());
        if(ItemCount == 1)
        {
            System.out.println("Test Passed and Item added. Item count is "+ItemCount);
        }
        else {
            captureScreenShot(driver,"addItemToCart");
        }

    }

    @Test(priority = 4)
    public void removeItem()
    {

    }

}
