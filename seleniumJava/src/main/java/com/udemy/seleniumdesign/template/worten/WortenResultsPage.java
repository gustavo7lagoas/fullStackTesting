package com.udemy.seleniumdesign.template.worten;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WortenResultsPage {

    private WebDriverWait wait;

    @FindBy(css = "span.produc-card__name__link")
    private WebElement productLink;

    public WortenResultsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return this.wait.until(d -> productLink.isDisplayed());
    }

    public void selectProduct() {
        this.isDisplayed();
        productLink.click();
    }

}
