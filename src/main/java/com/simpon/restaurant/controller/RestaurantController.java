package com.simpon.restaurant.controller;

import com.simpon.restaurant.model.Restaurant;
import com.simpon.restaurant.model.Review;
import com.simpon.restaurant.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants(){
       return (this.restaurantService.getRestaurants());

    }
    @PostMapping("/{restaurantId}/reviews")
    public ResponseEntity<Review> addReviewToRestaurant(@PathVariable Long restaurantId, @RequestBody Review reviewToCreate ){
        Review createdReview = this.restaurantService.createReview(restaurantId,reviewToCreate);
        if (createdReview != null){
            return ResponseEntity.ok(createdReview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
