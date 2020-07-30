package com.daimongkol.aws.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
  private String make;
  private int numberOfSeats;
  private CarType type;
}
