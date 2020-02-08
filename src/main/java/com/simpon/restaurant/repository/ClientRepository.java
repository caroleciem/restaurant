package com.simpon.restaurant.repository;

import com.simpon.restaurant.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
