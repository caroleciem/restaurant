package com.simpon.restaurant.service;

import com.simpon.restaurant.model.Review;

import java.util.List;

public interface ReviewService {

    /**
     * Get the complete list of restaurants
     * @return the complete list from persistence layer.
     */
    List<Review> getReviews();
}
