package com.udemy.seleniumdesign.command.commom;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
    
    protected WebDriverWait wait;
    protected WebDriver driver;

    public AbstractComponent(final WebDriver driver) {

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();

}
