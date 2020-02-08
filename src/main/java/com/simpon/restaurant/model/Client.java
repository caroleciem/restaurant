package com.simpon.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Client {
    @Id
    @SequenceGenerator(name="client_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_id")
    private Long Id;

    @Column(nullable= false)
    private String firstName;

    @Column (nullable= false)
    private String lastName;

    @Column (nullable= false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "visitors")
    private Set<Restaurant> visitors = new HashSet<>();
}
