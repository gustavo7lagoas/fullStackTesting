package com.udemy.seleniumdesign.strategy.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;
    private PaymentStrategy paymentOption;
    private UserInformation userInformation;
    private OrderComponent order;

    public PaymentPage(final WebDriver driver) {
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.order = PageFactory.initElements(driver, OrderComponent.class);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public OrderComponent getOrder() {
        return order;
    }

    public void setPaymentStrategy(PaymentStrategy paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public PaymentStrategy getPaymentOption() {
        return paymentOption;
    }

}
