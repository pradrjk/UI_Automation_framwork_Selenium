package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
    {
        if(browserName.equals("Chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            driver=new ChromeDriver(options);
            WebDriverManager.chromedriver().setup();
            driver.manage().window().maximize();
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        }
        return driver;

    }

    public static void quitBrowser(WebDriver driver)
    {
        driver.quit();
    }
}
