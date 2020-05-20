package com.udemy.seleniumdesign.test;

import com.udemy.seleniumdesign.factory.driver.DriverFactory;
import com.udemy.seleniumdesign.factory.driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
