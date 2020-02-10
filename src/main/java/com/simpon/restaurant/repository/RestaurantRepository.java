package com.simpon.restaurant.repository;

import com.simpon.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
    @Query("SELECT DISTINCT restaurant FROM Restaurant restaurant JOIN restaurant.reviews reviews where reviews.note >= :lowest and reviews.note <= :highest")
    List<Restaurant> findAllByReviewsNoteBetween(Integer lowest, Integer highest);
}
