package com.udemy.seleniumdesign.strategy.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.udemy.seleniumdesign.strategy.common.AbstractComponent;

public class PayByNetBanking extends AbstractComponent implements PaymentStrategy {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement accNumber;

    @FindBy(id = "pin")
    private WebElement pin;

    public PayByNetBanking(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillPaymentDetails(Map<String, String> paymentDetails) {
        Select bankOptions = new Select(this.bank);
        bankOptions.selectByVisibleText(paymentDetails.get("bank"));
        accNumber.sendKeys(paymentDetails.get("accNumber"));
        pin.sendKeys(paymentDetails.get("pin"));
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bank.isDisplayed());
    }


}
