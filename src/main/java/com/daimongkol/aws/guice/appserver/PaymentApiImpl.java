package com.daimongkol.aws.guice.appserver;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class PaymentApiImpl implements PaymentApi {
    private final PaymentApiClient httpClient;

    @Inject
    public PaymentApiImpl(PaymentApiClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public void paid(Payment payment) {
        httpClient.submitPayment(payment.price, payment.currency);
    }
}
