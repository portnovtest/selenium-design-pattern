package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> adminComponentPresent = (dashboardPage -> shouldDisplay(
            dashboardPage.getAdminComponents()));

    private static final Consumer<DashboardPage> adminComponentNotPresent = (dashboardPage -> shouldNotDisplay(
            dashboardPage.getAdminComponents()));

    private static final Consumer<DashboardPage> superuserComponentPresent = (dashboardPage -> shouldDisplay(
            dashboardPage.getSuperuserComponents()));

    private static final Consumer<DashboardPage> superuserComponentNotPresent = (dashboardPage -> shouldNotDisplay(
            dashboardPage.getSuperuserComponents()));

    private static final Consumer<DashboardPage> guestComponentPresent = (dashboardPage -> shouldDisplay(
            dashboardPage.getGuestComponents()));

    private static final Consumer<DashboardPage> guestComponentNotPresent = (dashboardPage -> shouldNotDisplay(
            dashboardPage.getGuestComponents()));

    //role selection
    private static final Consumer<DashboardPage> adminSelection = (dashboardPage -> dashboardPage.selectRole("admin"));
    private static final Consumer<DashboardPage> superuserSelection = (dashboardPage -> dashboardPage.selectRole("superuser"));
    private static final Consumer<DashboardPage> guestSelection = (dashboardPage -> dashboardPage.selectRole("guest"));

    //user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent)
            .andThen(superuserComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> superuserPage = superuserSelection.andThen(guestComponentPresent)
            .andThen(superuserComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent)
            .andThen(superuserComponentPresent).andThen(adminComponentPresent);
}
