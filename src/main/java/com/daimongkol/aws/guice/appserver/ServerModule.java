package com.daimongkol.aws.guice.appserver;

import com.daimongkol.aws.guice.appserver.annotations.PaymentUrl;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigRenderOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerModule extends AbstractModule {
    protected void configure() {
        //add configuration logic here
        Config config = ConfigFactory.load();

        bindConstant().annotatedWith(PaymentUrl.class)
                .to(config.getString("payment-api.url"));

        bind(PaymentApiClient.class).to(HttpClientImpl.class);
        bind(PaymentApi.class).to(PaymentApiImpl.class);
        bind(Database.class).to(DatabaseImpl.class).in(Singleton.class);

        String render = config.root().render(ConfigRenderOptions.defaults());
        log.info(render);
    }
}
