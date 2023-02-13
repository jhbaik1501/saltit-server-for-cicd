package com.posomo.saltit.domain.restaurant.entity.manyToOne;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("OPEN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantOpenTime extends RestaurantTime{
}