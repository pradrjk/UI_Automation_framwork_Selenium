package testCases;

import baseClass.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

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
            Assert.assertTrue(false);
        }



    }


}
