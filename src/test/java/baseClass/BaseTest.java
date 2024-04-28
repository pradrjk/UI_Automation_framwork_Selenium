package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ReadConfig;


import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    //reads config file
    ReadConfig readConfig;
    {
        try {
            readConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //====================Initializing public variables that we use
    //by using following code, it omits the need to use of the chrome driver as a separate file. what is does is get dependencies using maven
    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver=new ChromeDriver(options);

    public WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
    public String BaseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    @BeforeTest
    void Setup()
    {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        driver.get(BaseURL);

    }
    @Test
    void testSteps() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")));
        Assert.assertEquals(pageTitle.getText(),"Swag Labs");

        //Logger.info("Login test passed.Successfully logged into Dashboard");

    }

    @AfterTest
    public void tearDown() {
       // extent.flush();
        driver.close();
    }
}
