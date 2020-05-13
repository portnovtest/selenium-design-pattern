package com.udemy.seleniumdesign.test.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.factory.driver.DriverManager;
import com.udemy.seleniumdesign.factory.driver.DriverManagerFactory;
import com.udemy.seleniumdesign.factory.driver.DriverType;
import com.udemy.seleniumdesign.factory.page.GoogleFactory;
import com.udemy.seleniumdesign.factory.page.GooglePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends BaseTest {

    DriverManager driverManager;
    WebDriver driver;
    private GooglePage googlePage;

    @BeforeTest
    public void beforeTest(){
        driverManager = DriverManagerFactory.getManager(DriverType.SAFARI);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driverManager.quitDriver();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultsCount = this.googlePage.getResultsCount();

        System.out.println("Result Count: " + resultsCount);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design patterns"},
                {"SA", "docker"},
                {"ES", "selenium"}
        };
    }
}
