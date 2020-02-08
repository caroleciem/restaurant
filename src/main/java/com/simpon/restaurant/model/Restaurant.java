package com.simpon.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Restaurant {
    @Id
    @SequenceGenerator(name="restaurant_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq_id")
    private Long Id;

    @Column (nullable= false)
    private String name;

    @Column (nullable= false)
    private Integer seats;

    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;

    @OneToMany(mappedBy="restaurant")
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name ="restaurants_visits",
            joinColumns = @JoinColumn(name ="restaurant_id"),
            inverseJoinColumns= @JoinColumn(name = "client_id")
    )
    private Set<Client> visitors = new HashSet<>();


    public String getName() {
        return name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Client> getVisitors() {
        return visitors;
    }

    public void setVisitors(Set<Client> visitors) {
        this.visitors = visitors;
    }
}
