package com.example.alpha.city.repository;

import com.example.alpha.city.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    // You can define custom query methods here if needed
}