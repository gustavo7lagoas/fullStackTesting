package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private BeforeYouContinueToGoogleDialog beforeYouContinueToGoogleDialog;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.beforeYouContinueToGoogleDialog = PageFactory.initElements(driver, BeforeYouContinueToGoogleDialog.class);
    }

    public void goTo() {
        this.driver.get("https://www.google.com");
        beforeYouContinueToGoogleDialog.selectRejectAll();
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

}
