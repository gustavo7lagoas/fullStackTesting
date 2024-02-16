package com.udemy.seleniumdesign.command.commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Arrays;

public class NotificationsHomePage {

    private WebDriver driver;
    private DissmissalAlertComponent dissmissalAlertComponent;
    private SimpleAlertComponent simpleAlertsComponent;


    public NotificationsHomePage(final WebDriver driver) {
        this.driver = driver;
        this.dissmissalAlertComponent = PageFactory.initElements(driver, DissmissalAlertComponent.class);
        this.simpleAlertsComponent = PageFactory.initElements(driver, SimpleAlertComponent.class);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
            new DismissalAlertValidator(this.dissmissalAlertComponent.getDissmissAlertInfo()),
            new DismissalAlertValidator(this.dissmissalAlertComponent.getDissmissAlertSuccess()),
            new DismissalAlertValidator(this.dissmissalAlertComponent.getDissmissAlertWarning()),
            new DismissalAlertValidator(this.dissmissalAlertComponent.getDissmissAlertDanger()),
            new SimpleAlertValidator(this.simpleAlertsComponent.getBtnSuccess(), this.simpleAlertsComponent.getAlertSuccess()),
            new SimpleAlertValidator(this.simpleAlertsComponent.getBtnWarning(), this.simpleAlertsComponent.getAlertWarning()),
            new SimpleAlertValidator(this.simpleAlertsComponent.getBtnDanger(), this.simpleAlertsComponent.getAlertDanger()),
            new SimpleAlertValidator(this.simpleAlertsComponent.getBtnInfo(), this.simpleAlertsComponent.getAlertInfo())
            );
    }

}
