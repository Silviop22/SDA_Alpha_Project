package com.example.alpha.airport.repository;

import com.example.alpha.airport.model.Airport;
import com.example.alpha.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    // You can define custom query methods here if needed
}