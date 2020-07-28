package com.daimongkol.aws.guice.appserver;

public interface PaymentApiClient {
    void submitPayment(Float price, String currency);
}
