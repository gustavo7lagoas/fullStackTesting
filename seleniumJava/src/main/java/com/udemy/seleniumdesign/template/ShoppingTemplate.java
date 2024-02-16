package com.udemy.seleniumdesign.template;

public abstract class ShoppingTemplate {

    public abstract void lauchSite();

    public abstract void searchForProduct();

    public abstract void selectProduct();

    public abstract void buy();

    public void shop() {
        lauchSite();
        searchForProduct();
        selectProduct();
        buy();
    }
}
