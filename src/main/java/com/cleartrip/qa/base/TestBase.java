package com.cleartrip.qa.base;

import com.cleartrip.qa.util.TestUtil;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(TestUtil.CONFIG_PATH);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializer() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            if (PlatformUtil.isMac()) {
                System.setProperty("webdriver.chrome.driver", "chromedriver");
            }
            if (PlatformUtil.isWindows()) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            }
            if (PlatformUtil.isLinux()) {
                System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            }
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
    }
}
