package com.udemy.seleniumdesign.test.strategy;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.strategy.main.PaymentMethodFactory;
import com.udemy.seleniumdesign.strategy.main.PaymentPage;
import com.udemy.seleniumdesign.strategy.main.PaymentStrategy;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeTest
    public void setupPages() {
        this.paymentPage = new PaymentPage(driver);
    }

    @Test(dataProvider = "getData")
    public void canCreateOrder(String paymentOption, Map<String, String> userInformation, Map<String, String> paymentDetails) {
        paymentPage.goTo();
        paymentPage.getUserInformation().isDisplayed();
        paymentPage.getUserInformation().fillUserInformation(userInformation.get("firstName"), userInformation.get("lastName"), userInformation.get("email"));
        
        paymentPage.setPaymentStrategy(PaymentMethodFactory.get(paymentOption, driver));
        paymentPage.getPaymentOption().fillPaymentDetails(paymentDetails);

        paymentPage.getOrder().placeOrder();

        String orderNumber = paymentPage.getOrder().getOrderNumber();
        System.out.println("Order number is: " + orderNumber);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][] getData() {

        Map<String,String> userInfo = Maps.newHashMap();
        userInfo.put("firstName", "gust");
        userInfo.put("lastName", "fons");
        userInfo.put("email", "gusfons@mail.com");

        Map<String,String> cc = Maps.newHashMap();
        cc.put("cCardNumber", "123456789012");
        cc.put("cCardYear", "2024");
        cc.put("cCardCVV", "67890");

        Map<String,String> pp = Maps.newHashMap();
        pp.put("paypalUsername", "gusfons@mail.com");
        pp.put("paypalPassword", "gf@g.c@");

        Map<String,String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("accNumber", "987654");
        nb.put("pin", "3456");


        return new Object[][] {
            {"CC", userInfo, cc},
            {"PP", userInfo, pp},
            {"NB", userInfo, nb}
        };
    }
}
