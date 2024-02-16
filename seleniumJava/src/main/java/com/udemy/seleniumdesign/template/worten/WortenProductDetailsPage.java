package com.udemy.seleniumdesign.template.worten;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WortenProductDetailsPage {

    @FindBy(css = "span.price--lg span.price__value")
    private WebElement mainPrice;

    private WebDriverWait wait;

    public WortenProductDetailsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getMainPrice() {
        this.wait.until(d -> mainPrice.isDisplayed());
        return this.mainPrice.getText();
    }
}
