package com.udemy.seleniumdesign.proxy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    public WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();

}
