package com.simpon.restaurant.service;

import com.simpon.restaurant.model.Restaurant;
import com.simpon.restaurant.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    /**
     * Get the complete list of restaurants
     * @return the complete list from persistence layer.
     */
    List<Restaurant> getRestaurants();

    /**
     * create review for restaurant
     * @param restaurantId id du restaurant
     * @param reviewToCreate review to create
     * @return created review
     */
    Review createReview(Long restaurantId,Review reviewToCreate);

    /**
     * remove review for restaurant
     * @param restaurantId id du restaurant
     * @param reviewId id review to delete
     * @return boolean true if removal possible, false otherwise
     */
    boolean deleteReview(Long restaurantId,Long reviewId);
}
