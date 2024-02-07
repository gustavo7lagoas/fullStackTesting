package com.udemy.seleniumdesign.strategy.main;

import java.util.Map;

public interface PaymentStrategy {

    void fillPaymentDetails(Map<String, String> paymentDetails);

}
