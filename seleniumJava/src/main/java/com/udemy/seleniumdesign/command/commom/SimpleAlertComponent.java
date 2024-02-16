package com.udemy.seleniumdesign.command.commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleAlertComponent extends AbstractComponent {

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement btnInfo;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement btnWarning;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement btnSuccess;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement btnDanger;

    @FindBy(css = "div.jq-icon-info")
    private WebElement alertInfo;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement alertWarning;

    @FindBy(css = "div.jq-icon-success")
    private WebElement alertSuccess;

    @FindBy(css = "div.jq-icon-error")
    private WebElement alertDanger;

    public SimpleAlertComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnInfo() {
        return btnInfo;
    }

    public WebElement getBtnWarning() {
        return btnWarning;
    }

    public WebElement getBtnSuccess() {
        return btnSuccess;
    }

    public WebElement getBtnDanger() {
        return btnDanger;
    }

    public WebElement getAlertInfo() {
        return alertInfo;
    }

    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public WebElement getAlertDanger() {
        return alertDanger;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> btnInfo.isDisplayed());
    }

}
