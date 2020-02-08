package com.simpon.restaurant.repository;

import com.simpon.restaurant.model.Restaurant;
import com.simpon.restaurant.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
