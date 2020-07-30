package com.daimongkol.aws.mapstruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  @Mapping(target = "seatCount", source = "numberOfSeats")
  @Mapping(target = "make", expression = "java(updateMake(car.getMake()))")
  @Mapping(target = "type", source = "type")
  CarDto carToCarDto(Car car);

  @InheritInverseConfiguration
  Car carDtoToCar(CarDto carDto);

  default String updateMake(String make) {
    return make + " - DTO";
  }
}
