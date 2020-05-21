package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {

    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGING");
    private OrderComponent orderComponent;

    public OrderComponentProxy(WebDriver driver) {
        String currentEnv = System.getProperty("env"); // DEV / QA / PROD / STAGING
        if (!EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(driver);
        }

    }

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }

    }
}
