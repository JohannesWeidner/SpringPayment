package com.example.payment;

public class PaymentDatabaseService {
    private final String[] paymentMethods = new String[]{"Banküberweisung", "Kreditkarte", "Rechnung", "Paypal"};

    public String[] getAllPaymentMethods() {
        return paymentMethods;
    }
}
