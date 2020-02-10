package com.simpon.restaurant.controller;

import com.simpon.restaurant.model.Restaurant;
import com.simpon.restaurant.model.Review;
import com.simpon.restaurant.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins="*")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants(){
       return (this.restaurantService.getRestaurants());

    }
    @GetMapping("/filter")
    public List<Restaurant>getfiltered(Integer lowest, Integer highest){

        return (this.restaurantService.getFilteredRestaurants(lowest,highest));
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
    @DeleteMapping("/{restaurantId}/reviews/{reviewIdToDelete}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long restaurantId,@PathVariable Long reviewId){
        boolean deletionIsPossible = this.restaurantService.deleteReview(restaurantId, reviewId);
        if (deletionIsPossible){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
