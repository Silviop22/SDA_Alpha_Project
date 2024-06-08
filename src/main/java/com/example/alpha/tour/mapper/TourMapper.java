package com.example.alpha.tour.mapper;


import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.model.TourDTO;

public class TourMapper {
    public static TourDTO toDTO(Tour tour) {
        TourDTO dto = new TourDTO();
        dto.setId(tour.getId());
        dto.setCity(tour.getCity());
        dto.setHotel(tour.getHotel());
        dto.setAirport(tour.getAirport());
        return dto;
    }
    public static Tour toEntity(TourDTO dto) {
        Tour tour = new Tour();
        tour.setId(dto.getId());
        tour.setCity(dto.getCity());
        tour.setHotel(dto.getHotel());
        tour.setAirport(dto.getAirport());
        return tour;
    }
}