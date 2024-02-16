package com.udemy.seleniumdesign.template.worten;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WortenSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(css = "a.search-suggestions-item")
    private WebElement searchOption;

    public WortenSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        this.driver.get("https://www.worten.pt/");
    }

    public void searchProduct(String productName) {
        this.searchBox.sendKeys(productName);
        this.wait.until(d -> this.searchOption.isDisplayed());
        this.searchOption.click();
    }
}
