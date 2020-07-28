package com.daimongkol.aws.guice;

import com.google.inject.*;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Slf4j
public class GuiceInternalTask {


    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface EnglishGreeting {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface SpanishGreeting {
    }


    static final class GuiceInternalModule extends AbstractModule {

        @Provides
        @EnglishGreeting
        static String englishGreeting() {
            return "Hello";
        }

        @Provides
        @SpanishGreeting
        static String spanishGreeting() {
            return "Buenos dias";
        }
    }

    static final class MultilingualGreeter {
        private final String englishGreeting;
        private final String spanishGreeting;

        @Inject
        public MultilingualGreeter(@EnglishGreeting String englishGreeting, @SpanishGreeting String spanishGreeting) {
            this.englishGreeting = englishGreeting;
            this.spanishGreeting = spanishGreeting;
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceInternalModule());
        String english = injector.getInstance(Key.get(String.class, EnglishGreeting.class));
        String spanish = injector.getInstance(Key.get(String.class, SpanishGreeting.class));

        MultilingualGreeter multilingualGreeter = new MultilingualGreeter(english, spanish);

        log.info("English Greeting: " + multilingualGreeter.englishGreeting);
        log.info("Spanish Greeting: " + multilingualGreeter.spanishGreeting);
    }
}
