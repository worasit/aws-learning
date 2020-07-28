package com.daimongkol.aws.guice.appserver;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boot {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ServerModule());
        PaymentApi paymentApi = injector.getInstance(PaymentApi.class);
        Database database = injector.getInstance(Database.class);
        MyApplicationServer applicationServer = new MyApplicationServer(database, paymentApi);

        applicationServer.Start(Float.parseFloat(args[0]), args[1]);
    }
}
