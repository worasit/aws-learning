package com.daimongkol.aws.guice.appserver;

import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class DatabaseImpl implements Database {
    @Override
    public void insertPayment(Payment payment) {
        log.info("insert payment with price: " + payment.price + " " + payment.currency);
    }
}
