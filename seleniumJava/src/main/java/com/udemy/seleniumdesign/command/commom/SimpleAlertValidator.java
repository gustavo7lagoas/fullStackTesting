package com.udemy.seleniumdesign.command.commom;

import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class SimpleAlertValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public SimpleAlertValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        button.click();
        Boolean isDisplayed = notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        Boolean isDissmissed = !notification.isDisplayed();
        return isDisplayed && isDissmissed;
    }

}
