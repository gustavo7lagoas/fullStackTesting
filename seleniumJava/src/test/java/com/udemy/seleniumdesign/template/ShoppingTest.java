package com.udemy.seleniumdesign.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.test.BaseTest;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate template) {
        template.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
            new WortenShopping(driver, "xbox")
        };
    }

}
