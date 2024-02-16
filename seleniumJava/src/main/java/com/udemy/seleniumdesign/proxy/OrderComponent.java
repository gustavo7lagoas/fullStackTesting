package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponent extends AbstractComponent implements OrderInterface {

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @FindBy(id = "buy")
    private WebElement buyNow;

    public OrderComponent(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
