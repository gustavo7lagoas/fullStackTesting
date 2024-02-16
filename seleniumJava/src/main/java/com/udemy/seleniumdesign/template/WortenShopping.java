package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.template.worten.WortenProductDetailsPage;
import com.udemy.seleniumdesign.template.worten.WortenResultsPage;
import com.udemy.seleniumdesign.template.worten.WortenSearchPage;

public class WortenShopping extends ShoppingTemplate {

    private String product;

    private WortenSearchPage wortenSearchPage;
    private WortenResultsPage wortenResultsPage;
    private WortenProductDetailsPage wortenProductDetailsPage;

    public WortenShopping(WebDriver driver, String product) {
        this.product = product;
        this.wortenSearchPage = PageFactory.initElements(driver, WortenSearchPage.class);
        this.wortenResultsPage = PageFactory.initElements(driver, WortenResultsPage.class);
        this.wortenProductDetailsPage = PageFactory.initElements(driver, WortenProductDetailsPage.class);
    }

    @Override
    public void lauchSite() {
        this.wortenSearchPage.openPage();
    }

    @Override
    public void searchForProduct() {
        this.wortenSearchPage.searchProduct(product);
    }

    @Override
    public void selectProduct() {
        this.wortenResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        String price = this.wortenProductDetailsPage.getMainPrice();
        System.out.println(price);
    }


}
