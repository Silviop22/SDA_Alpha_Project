package com.example.alpha.admin;


import com.example.alpha.booking.mapper.BookingMapper;
import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.model.BookingStatus;
import com.example.alpha.booking.repository.BookingRepository;
import com.example.alpha.tour.mapper.TourMapper;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(BookingMapper::toDTO).collect(Collectors.toList());
    }

    public BookingStatusDTO getBookingStatus() {
        List<Booking> bookings = bookingRepository.findAll();
        long booked = bookings.stream().filter(b -> b.getStatus() == BookingStatus.BOOKED).count();
        long cancelled = bookings.stream().filter(b -> b.getStatus() == BookingStatus.CANCELLED).count();

        BookingStatusDTO statusDTO = new BookingStatusDTO();
        statusDTO.setBooked(booked);
        statusDTO.setCancelled(cancelled);
        return statusDTO;
    }

    public TourDTO createTour(TourDTO tourDTO) {
        Tour tour = TourMapper.toEntity(tourDTO);
        tour = tourRepository.save(tour);
        return TourMapper.toDTO(tour);
    }

    public TourDTO updateTour(Long id, TourDTO tourDTO) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tour not found"));
        tour.setName(tourDTO.getName());
        tour.setDescription(tourDTO.getDescription());
        tour.setStandard(tourDTO.getStandard());
        tour.setPrice(tourDTO.getPrice());
        tour = tourRepository.save(tour);
        return TourMapper.toDTO(tour);
    }

    public void deleteTour(Long id) {
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found");
        }
        tourRepository.deleteById(id);
    }
}