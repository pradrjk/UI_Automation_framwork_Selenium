package utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
    Properties pro;

    public ReadConfig() throws IOException {
        File src = new File("Configuration/config.properties");

        FileInputStream file = new FileInputStream(src);
        pro = new Properties();
        pro.load(file);

    }
    public String getApplicationURL()
    {
        String URL = pro.getProperty("BaseURL");
        return URL;
    }
    public String getUsername()
    {
        String UserName = pro.getProperty("Username");
        return UserName;
    }
    public String getPassword()
    {
        String Password = pro.getProperty("Password");
        return Password;
    }
    public String getBrowser()
    {
        String Browser = pro.getProperty("Browser_Name");
        return Browser;
    }
}
