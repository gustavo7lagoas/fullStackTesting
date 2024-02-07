package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;

public class NavigationBar extends AbstractComponent {

    @FindBy(css = "div[role=navigation]")
    public WebElement bar;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    public void goToVideos() {
        this.videos.click();
    }

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bar.isDisplayed());
    }

}
