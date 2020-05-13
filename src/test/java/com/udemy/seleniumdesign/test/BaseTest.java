package com.udemy.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/phildolganov/Desktop/Desktop/drivers/geckodriver");
        //System.setProperty("webdriver.chrome.driver", "/Users/phildolganov/Desktop/Desktop/drivers/chromedriver");
        this.driver = new FirefoxDriver();
        //this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
