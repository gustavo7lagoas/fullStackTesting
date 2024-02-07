package com.udemy.seleniumdesign.strategy.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.strategy.common.AbstractComponent;

public class PayByPaypal extends AbstractComponent implements PaymentStrategy{

    @FindBy(id = "paypal_username")
    private WebElement paypalUsername;

    @FindBy(id = "paypal_password")
    private WebElement paypalPassword;

    public PayByPaypal(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillPaymentDetails(Map<String, String> paymentDetails) {
        this.paypalUsername.sendKeys(paymentDetails.get("paypalUsername"));
        this.paypalPassword.sendKeys(paymentDetails.get("paypalPassword"));
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.paypalUsername.isDisplayed());
    }



}
