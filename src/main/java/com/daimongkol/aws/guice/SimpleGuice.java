package com.daimongkol.aws.guice;

import com.google.inject.*;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Slf4j
public class SimpleGuice {

  public static void main(String[] args) {
    /*
     * Guice.createInjector() takes of or more modules, and returns a new Injector
     * instance. Most applications will call this method exactly once, in the
     * main() method.
     */
    Injector injector = Guice.createInjector(new AnnotationStyleModule());

    /*
     * Now that we have got the injector, we can build objects.
     */
    Greeter greeter = injector.getInstance(Greeter.class);

    greeter.sayHello();
  }

  /** Creates a specific annotation to provide data by annotation instead of data type */
  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @interface Count {}

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @interface Message {}

  //    static class BinderStyleModule extends AbstractModule {
  //        @Override
  //        protected void configure() {
  //            bindConstant().annotatedWith(Message.class).to("hello world");
  //            bindConstant().annotatedWith(Count.class).to(3);
  //        }
  //    }

  /**
   * Guice modue that provides bindings for message and count used in Annotation style {@link
   * Greeter}
   */
  static class AnnotationStyleModule extends AbstractModule {
    @Provides
    @Count
    static Integer provideCount() {
      return 3;
    }

    @Provides
    @Message
    static String provideMessage() {
      return "hello world";
    }

    @Override
    protected void configure() {
      super.configure();
    }
  }

  class XXXProvider implements Provider<String> {
    @Override
    public String get() {
      return null;
    }
  }

  static class Reporter {

    public Reporter() {}

    void print(String message) {
      System.out.println(message);
    }
  }

  static class Greeter {
    private final String message;
    private final Integer count;
    private final Reporter reporter;

    /**
     * Greeter declares that it needs a string message and an integer representing the number of
     * time the message to be printed.
     *
     * <p>The @Inject annotation marks this constructor as eligible to be used by Guice
     *
     * @param message
     * @param count
     * @param reporter
     */
    @Inject
    Greeter(@Message String message, @Count Integer count, Reporter reporter) {
      this.message = message;
      this.count = count;
      this.reporter = reporter;
    }

    void sayHello() {
      for (int i = 0; i < this.count; i++) {
        reporter.print(this.message);
      }
    }
  }
}
