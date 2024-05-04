package baseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ReadConfig;
import utils.BrowserFactory;

import java.io.IOException;


public class BaseTest {
    public WebDriver driver;
    public static ReadConfig config;


    @BeforeSuite
    public void setUpSuite() throws IOException {
        config=new ReadConfig();

    }

    @BeforeClass
    public void setUp()
    {
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationURL());
    }
    @AfterClass
    public void tearDown()
    {
        BrowserFactory.quitBrowser(driver);
    }

}
