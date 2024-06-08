package com.example.alpha.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.alpha.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    // You can define custom query methods here if needed
}