package com.posomo.saltit.respository;

import com.posomo.saltit.domain.restaurant.dto.RestaurantSummary;
import com.posomo.saltit.domain.restaurant.entity.Restaurant;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
    @Query(value = "select r.title_image_url,r.name,r.score,rm.price,rm.name,ft.name," +
            "ST_Distance_Sphere(POINT(:userLongitude,:userLatitude), POINT(rl.longitude,rl.latitude)) as distance " +
            "from restaurant r join food_type ft on r.food_type_id = ft.id " +
            "join restaurant_menu rm on r.id = rm.restaurant_id join restaurant_location rl on r.id=rl.restaurant_id " +
            "where rm.order_number = 1 and (:maxPrice is null or rm.price <= :maxPrice) and (:foodTypeName is null or " +
            "ft.name = :foodTypeName) " +
            "and (:maxDistance is null or ST_Distance_Sphere(POINT(:userLongitude,:userLatitude), " +
            "POINT(rl.longitude,rl.latitude)) < :maxDistance) " +
            "order by score DESC",
            nativeQuery = true)
    Slice<Object[]> findRestaurantByFilter(@Param(value = "maxPrice")Integer maxPrice,
                                                    @Param(value = "foodTypeName")String foodTypeName,
                                                    @Param(value = "userLongitude")Double userLongitude,
                                                    @Param(value = "userLatitude")Double userLatitude,
                                                    @Param(value = "maxDistance")Double maxDistance,
                                                    Pageable pageable);
}
