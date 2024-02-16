package com.udemy.seleniumdesign.test.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.command.commom.NotificationsHomePage;
import com.udemy.seleniumdesign.test.BaseTest;

public class NotificationPageTest extends BaseTest {

    private NotificationsHomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new NotificationsHomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
            .stream()
            .map(ev -> ev.validate())
            .forEach(b -> Assert.assertTrue(b));
    }

}
