package com.udemy.seleniumdesign.proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderComponentProxy extends AbstractComponent implements OrderInterface {

    private static final List<String> EXCLUDED = Arrays.asList("PROD","STAGGING");
    private OrderComponent orderComponent;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @FindBy(id = "buy")
    private WebElement buyNow;

    public OrderComponentProxy(final WebDriver driver) {
        super(driver);
        String env = System.getProperty("env");
        if(!EXCLUDED.contains(env)) {
            this.orderComponent = new OrderComponent(driver);
        }
    }

    public String getOrderNumber() {
        if(Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.getOrderNumber();
        } else {
            return "SKIPPED";
        }
    }

    public void placeOrder() {
        if(Objects.nonNull(this.orderComponent)) {
            this.orderComponent.placeOrder();
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> orderNumber.isDisplayed());
    }

}
