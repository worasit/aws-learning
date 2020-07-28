package com.daimongkol.aws.guice.appserver;


import com.google.inject.Inject;

public class MyApplicationServer {
    private final Database database;
    private final PaymentApi paymentApi;

    @Inject
    public MyApplicationServer(Database database, PaymentApi paymentApi) {
        this.database = database;
        this.paymentApi = paymentApi;
    }

    public void Start(Float price, String currency) {
        Payment payment = Payment.builder()
                .price(price)
                .currency(currency)
                .build();

        this.database.insertPayment(payment);
        this.paymentApi.paid(payment);
    }
}
