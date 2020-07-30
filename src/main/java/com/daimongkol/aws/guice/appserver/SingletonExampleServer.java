package com.daimongkol.aws.guice.appserver;

import com.google.inject.*;


interface Calculator {
  Double getNumber();
}

interface NumberGenerator {
  Double getRandomNumber();
}

class CalculatorModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(NumberGenerator.class).to(NumberGeneratorImpl.class);
    bind(Calculator.class).to(CalculatorImpl.class);
  }
}

class NumberGeneratorImpl implements NumberGenerator {

  private final Double randomNumber;

  public NumberGeneratorImpl() {
    this.randomNumber = Math.random();
  }

  @Override
  public Double getRandomNumber() {
    return randomNumber;
  }
}

// Comment this out to see the different result of number
//@Singleton
class CalculatorImpl implements Calculator {

  private final NumberGenerator numberGenerator;

  @Inject
  CalculatorImpl(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public Double getNumber() {
    return numberGenerator.getRandomNumber();
  }
}


public class SingletonExampleServer {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(Stage.PRODUCTION, new CalculatorModule());

    Calculator calculator1 = injector.getInstance(Calculator.class);
    Calculator calculator2 = injector.getInstance(Calculator.class);
    System.out.println(calculator1.getNumber());
    System.out.println(calculator2.getNumber());

  }
}
