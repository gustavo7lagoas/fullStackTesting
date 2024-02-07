package com.udemy.seleniumdesign.strategy.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.strategy.common.AbstractComponent;

public class UserInformation extends AbstractComponent {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInformation(final WebDriver driver) {
        super(driver);
    }

    public void fillUserInformation(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.firstName.isDisplayed());
    }



}
