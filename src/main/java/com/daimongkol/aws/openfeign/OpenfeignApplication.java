package com.daimongkol.aws.openfeign;

import com.daimongkol.aws.openfeign.models.Contributor;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.metrics5.Metrics5Capability;
import feign.slf4j.Slf4jLogger;
import io.dropwizard.metrics5.Counter;
import io.dropwizard.metrics5.Meter;
import io.dropwizard.metrics5.MetricRegistry;
import io.dropwizard.metrics5.Timer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static io.dropwizard.metrics5.MetricRegistry.name;

@Slf4j
public class OpenfeignApplication {
  public static void main(String[] args) throws InterruptedException {

    MetricRegistry metricRegistry = new MetricRegistry();
    Meter request = metricRegistry.meter("request");
    Counter counter = metricRegistry.counter("count");
    Timer timer = metricRegistry.timer(name(GitHub.class, "responses"));

    GitHub github = Feign.builder()
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .mapAndDecode((response, type) -> response, new GsonDecoder())
            .addCapability(new Metrics5Capability(metricRegistry))
            .target(GitHub.class, "https://api.github.com");
    request.mark();
    Timer.Context context = timer.time();


    List<Contributor> contributors = github.contributors("OpenFeign", "feign");
    for (Contributor contributor : contributors) {
      counter.inc();
      System.out.println(String.format("%s (%d) %s", contributor.getLogin(),
              contributor.getContributions(), contributor.getAvatarUrl()));
      Thread.sleep(100);
    }


    System.out.println(request.getMeanRate());
    System.out.println(counter.getCount());

  }
}
