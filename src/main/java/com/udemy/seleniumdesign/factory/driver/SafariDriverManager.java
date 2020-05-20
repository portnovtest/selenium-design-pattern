package com.udemy.seleniumdesign.factory.driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

public class SafariDriverManager extends DriverManager {

    private SafariDriverService saService;

    @Override
    protected void startService() {
        if (null == saService) {
            try {
                saService = new SafariDriverService.Builder()
                        .usingAnyFreePort()
                        .build();

                saService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != saService && saService.isRunning())
            saService.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        SafariOptions options = new SafariOptions();
        capabilities.setCapability(SafariOptions.CAPABILITY, options);
        driver = new SafariDriver(saService, options);
    }
}
