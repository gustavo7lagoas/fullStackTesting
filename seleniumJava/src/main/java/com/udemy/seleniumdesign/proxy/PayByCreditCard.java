package com.udemy.seleniumdesign.proxy;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayByCreditCard extends AbstractComponent implements PaymentStrategy {

    @FindBy(id = "cc")
    private WebElement cCardNumber;

    @FindBy(id = "year")
    private WebElement cCardYear;

    @FindBy(id = "cvv")
    private WebElement cCardCVV;

    public PayByCreditCard(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillPaymentDetails(Map<String, String> paymentDetails) {
        cCardNumber.sendKeys(paymentDetails.get("cCardNumber"));
        cCardYear.sendKeys(paymentDetails.get(("cCardYear")));
        cCardCVV.sendKeys(paymentDetails.get("cCardCVV"));
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.cCardYear.isDisplayed());
    }

}
