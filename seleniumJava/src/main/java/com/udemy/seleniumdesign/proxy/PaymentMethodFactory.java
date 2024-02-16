package com.udemy.seleniumdesign.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;


public class PaymentMethodFactory {

    private static final Function<WebDriver, PaymentStrategy> CC = (d) -> new PayByCreditCard(d);
    private static final Function<WebDriver, PaymentStrategy> NB = (d) -> new PayByNetBanking(d);

    private static final Map<String,Function<WebDriver, PaymentStrategy>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    public static PaymentStrategy get(String paymentMethod, WebDriver driver) {
        return MAP.get(paymentMethod).apply(driver);
    }

}
