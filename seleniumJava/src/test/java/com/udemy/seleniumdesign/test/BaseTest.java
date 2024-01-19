package com.udemy.seleniumdesign.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void  setupDriver() {
        System.setProperty("webdriver.chromium.driver", "/usr/local/bin/chromedriver");
        this.driver = new ChromeDriver();
        
    }

    @AfterClass
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
