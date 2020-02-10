package com.simpon.restaurant.service;

import com.simpon.restaurant.model.Restaurant;
import com.simpon.restaurant.model.Review;
import com.simpon.restaurant.repository.RestaurantRepository;
import com.simpon.restaurant.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;
    private ReviewRepository reviewRepository;

    //constructor
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository){
        this.restaurantRepository=restaurantRepository;
        this.reviewRepository =reviewRepository;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(Integer lowest, Integer highest) {
        return restaurantRepository.findAllByReviewsNoteBetween(lowest, highest);
    }

    @Override
    public Review createReview(Long restaurantId, Review reviewToCreate) {
        Optional<Restaurant> restaurant = this.restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()){
            reviewToCreate.setRestaurant(restaurant.get());
            return this.reviewRepository.save(reviewToCreate);

        }else{
            return null;
        }

    }

    @Override
    public boolean deleteReview(Long restaurantId, Long reviewId) {
        Optional<Restaurant> restaurant = this.restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()){
            List<Review> listReviews = restaurant.get().getReviews();
            boolean reviewExisting = false;
            for (Review review : listReviews){
                if (review.getId()== reviewId ){
                   reviewExisting = true;
                   break;
                }
            }
            if (reviewExisting) {
                this.reviewRepository.deleteById(reviewId);
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }


}
