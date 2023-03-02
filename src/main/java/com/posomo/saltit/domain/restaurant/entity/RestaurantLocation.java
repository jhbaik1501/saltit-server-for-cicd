package com.posomo.saltit.domain.restaurant.entity;

import com.posomo.saltit.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantLocation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column(length = 200)
    private String roadAddress;
    @Column()
    private BigDecimal latitude;
    @Column()
    private BigDecimal longitude;
    @Builder
    public RestaurantLocation(Restaurant restaurant, String roadAddress, BigDecimal latitude, BigDecimal longitude) {
        this.restaurant = restaurant;
        this.roadAddress = roadAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
