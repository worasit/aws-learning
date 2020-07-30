package com.daimongkol.aws.mapstruct;

import org.junit.Assert;
import org.junit.Test;

public class CarMapperTest {

  @org.junit.Test
  public void carToCarDto() {
    //given
    Car car = new Car("Morris", 5, CarType.Sedan);
    CarDto expectedCarDto = new CarDto("Morris - DTO", 5, "Sedan");

    //when
    CarDto actualCarDto = CarMapper.INSTANCE.carToCarDto(car);

    //then
    Assert.assertEquals(expectedCarDto, actualCarDto);
  }

  @Test
  public void carDtoToCar() {
    //given
    Car expectedCar = new Car("Morris - DTO", 5, CarType.Sedan);
    CarDto carDto = new CarDto("Morris", 5, "Sedan");

    //when
    Car car = CarMapper.INSTANCE.carDtoToCar(carDto);

    //then
    Assert.assertEquals(car, expectedCar);
  }
}