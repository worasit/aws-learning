package com.daimongkol.aws.openfeign;

import com.daimongkol.aws.openfeign.models.Contributor;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OpenfeignApplication {
    public static void main(String[] args) {
        GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors)
            log.info(String.format("%s (%d)", contributor.getLogin(), contributor.getContributions()));
    }
}
