package testCases;

import baseClass.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC001 extends BaseTest {




    @Test(priority =1)
    public void verifyLogin()
    {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(BaseTest.config.getUsername());
        driver.findElement(By.id("password")).sendKeys(BaseTest.config.getPassword());
        driver.findElement(By.id("login-button")).click();


    }


}
