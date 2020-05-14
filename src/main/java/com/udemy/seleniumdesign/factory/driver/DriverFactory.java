package com.udemy.seleniumdesign.factory.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    // chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "/Users/phildolganov/Desktop/Desktop/drivers/chromedriver");
        return new ChromeDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "/Users/phildolganov/Desktop/Desktop/drivers/geckodriver");
        return new FirefoxDriver();
    };

    // safari driver supplier
    private static final Supplier<WebDriver> safariDriverSupplier = SafariDriver::new;

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.SAFARI, safariDriverSupplier);
    }

    public static WebDriver getDriver(DriverType type) {
        WebDriver driver = driverMap.get(type).get();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

}
