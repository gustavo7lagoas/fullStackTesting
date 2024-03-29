package com.udemy.seleniumdesign.srp.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;

public class BeforeYouContinueToGoogleDialog extends AbstractComponent {

    @FindBy(xpath = "//*[text()=\"Reject all\"]" )
    private WebElement rejectAllButton;

    public BeforeYouContinueToGoogleDialog(final WebDriver driver) {
        super(driver);
    }

    public void selectRejectAll() {
        this.rejectAllButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.rejectAllButton.isDisplayed());
    }



}
