package com.udemy.seleniumdesign.command.commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DissmissalAlertComponent extends AbstractComponent {

    @FindBy(css = "div.row:nth-of-type(3) div:nth-child(2) div.alert-info")
    private WebElement dissmissAlertInfo;

    @FindBy(css = "div.row:nth-of-type(3) div:nth-child(2) div.alert-success")
    private WebElement dissmissAlertSuccess;

    @FindBy(css = "div.row:nth-of-type(3) div:nth-child(2) div.alert-danger")
    private WebElement dissmissAlertDanger;
    
    @FindBy(css = "div.row:nth-of-type(3) div:nth-child(2) div.alert-warning")
    private WebElement dissmissAlertWarning;
    
    public WebElement getDissmissAlertInfo() {
        return dissmissAlertInfo;
    }

    public WebElement getDissmissAlertSuccess() {
        return dissmissAlertSuccess;
    }

    public WebElement getDissmissAlertDanger() {
        return dissmissAlertDanger;
    }

    public WebElement getDissmissAlertWarning() {
        return dissmissAlertWarning;
    }

    public DissmissalAlertComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> dissmissAlertInfo.isDisplayed());
    }

}
