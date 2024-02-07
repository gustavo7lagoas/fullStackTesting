package com.udemy.seleniumdesign.strategy.main;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class PaymentMethodFactory {

    private static final Function<WebDriver, PaymentStrategy> CC = (d) -> new PayByCreditCard(d);
    private static final Function<WebDriver, PaymentStrategy> NB = (d) -> new PayByNetBanking(d);
    private static final Function<WebDriver, PaymentStrategy> PP = (d) -> new PayByPaypal(d);

    private static final Map<String,Function<WebDriver, PaymentStrategy>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
        MAP.put("PP", PP);
    }

    public static PaymentStrategy get(String paymentMethod, WebDriver driver) {
        return MAP.get(paymentMethod).apply(driver);
    }

}
