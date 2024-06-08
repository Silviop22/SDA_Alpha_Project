package com.example.alpha.hotel.repository;

import com.example.alpha.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.alpha.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // You can define custom query methods here if needed
}

