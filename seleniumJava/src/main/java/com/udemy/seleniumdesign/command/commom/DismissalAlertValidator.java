package com.udemy.seleniumdesign.command.commom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dissmissalAlertElement;

    public DismissalAlertValidator(WebElement dissmissalAlertElement) {
        this.dissmissalAlertElement = dissmissalAlertElement;
    }

    @Override
    public boolean validate() {
        Boolean isDisplayed = this.dissmissalAlertElement.isDisplayed();
        dissmissalAlertElement.findElement(By.cssSelector("button.close")).click();
        Boolean isDimissed = !(this.dissmissalAlertElement.isDisplayed());
        return isDisplayed && isDimissed;
    }

}
