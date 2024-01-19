package com.udemy.seleniumdesign.test.srp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.srp.GoogleMainPage;
import com.udemy.seleniumdesign.srp.GoogleResultPage;
import com.udemy.seleniumdesign.test.BaseTest;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test
    public void googleWorkflow() {

        String keyword = "selenium webdriver";
        int index = 3;

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enterSearch(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        googleResultPage.getSearchWidget().enterSearch(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        googleResultPage.getNavigationBar().goToVideos();
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        System.out.println(googleResultPage.getResultStat().getResultStatText());
    }
}
