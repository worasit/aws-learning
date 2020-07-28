package com.daimongkol.aws.guice.appserver;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boot {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(Stage.DEVELOPMENT, new ServerModule());


        /*
         * Guice just-in-time injection, no need to do manually binding inside module.
         */
        MyApplicationServer applicationServer = injector.getInstance(MyApplicationServer.class);

        applicationServer.Start(Float.parseFloat(args[0]), args[1]);
    }
}
