package com.example.alpha.tour.service;

//biznes logic



import com.example.alpha.tour.mapper.TourMapper;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.model.TourDTO;
import com.example.alpha.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;


    public boolean hasAvailability(Tour tour, int adults, int children) {
        return tour != null &&
                tour.getAdult_seats_available() >= adults &&
                tour.getChild_places_available() >= children;
    }

    public void updateAvailability(Tour tour, int adults, int children) {
        int availableAdultSeats = tour.getAdult_seats_available();
        int availableChildPlaces = tour.getChild_places_available();
        tour.setAdult_seats_available(availableAdultSeats - adults);
        tour.setChild_places_available(availableChildPlaces - children);
        tourRepository.save(tour);
    }

    public List<TourDTO> getAllTours() {
        return tourRepository.findAll().stream()
                .map(TourMapper::toDTO)
                .collect(Collectors.toList());
    }
    public Tour getTourById(Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        return TourMapper.toDTO(tour);
    }
    public TourDTO createTour(TourDTO tourDTO) {
        Tour tour = TourMapper.toEntity(tourDTO);
        Tour savedTour = tourRepository.save(tour);
        return TourMapper.toDTO(savedTour);
    }
    public TourDTO updateTour(Long id, TourDTO tourDTO) {
        Tour existingTour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        existingTour.setCity(tourDTO.getCity());
        existingTour.setHotel(tourDTO.getHotel());
        existingTour.setAirport(tourDTO.getAirport());
        Tour updatedTour = tourRepository.save(existingTour);
        return TourMapper.toDTO(updatedTour);
    }
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }


}