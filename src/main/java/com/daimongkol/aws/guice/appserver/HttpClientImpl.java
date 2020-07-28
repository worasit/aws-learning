package com.daimongkol.aws.guice.appserver;

import com.daimongkol.aws.guice.appserver.annotations.PaymentUrl;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class HttpClientImpl implements PaymentApiClient {

    private final String url;

    @Inject
    public HttpClientImpl(@PaymentUrl String url) {
        this.url = url;
    }

    @Override
    public void submitPayment(Float price, String currency) {
        log.info(String.format("Paid to %s with price: %f %s", url, price, currency));
    }
}
