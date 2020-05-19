package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    //buttons
    @FindBy(css = "div.button-box .btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box .btn-warning")
    private WebElement warnBtn;


    @FindBy(css = "div.button-box .btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box .btn-danger")
    private WebElement dangerBtn;


    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;


    //dismissal alert
    @FindBy(css = "div.card-body div.col-lg-4:nth-child(2) div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.card-body div.col-lg-4:nth-child(2) div.alert-warning")
    private WebElement dismissWarnAlert;

    @FindBy(css = "div.card-body div.col-lg-4:nth-child(2) div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.card-body div.col-lg-4:nth-child(2) div.alert-danger")
    private WebElement dismissDangerAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                //notification
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                //dismiss
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissDangerAlert)
        );
    }
}
