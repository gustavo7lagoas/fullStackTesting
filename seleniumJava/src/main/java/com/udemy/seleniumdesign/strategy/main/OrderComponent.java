package com.udemy.seleniumdesign.strategy.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.strategy.common.AbstractComponent;

public class OrderComponent extends AbstractComponent {

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @FindBy(id = "buy")
    private WebElement buyNow;

    public OrderComponent(final WebDriver driver) {
        super(driver);
    }

    public String getOrderNumber() {
        return orderNumber.getText();
    }

    public void placeOrder() {
        buyNow.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> orderNumber.isDisplayed());
    }

}
