package com.udemy.seleniumdesign.proxy;

import java.util.Map;

public interface PaymentStrategy {

    void fillPaymentDetails(Map<String, String> paymentDetails);

}

