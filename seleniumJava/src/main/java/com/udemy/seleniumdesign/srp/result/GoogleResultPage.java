package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

public class GoogleResultPage {

    private NavigationBar navigationBar;
    private ResultStat resultStat;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;

    public GoogleResultPage(final WebDriver driver) {
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

}
