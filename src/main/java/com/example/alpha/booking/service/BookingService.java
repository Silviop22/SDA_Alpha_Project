package com.example.alpha.booking.service;

import com.example.alpha.booking.mapper.BookingMapper;
import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.model.BookingStatus;
import com.example.alpha.booking.repository.BookingRepository;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.service.TourService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourService tourService;

    @Transactional
    public BookingDTO bookTour(Long tourId, List<String> participantsData, int adults, int children) {
        Tour tour = tourService.getTourById(tourId);
        if (tour == null) {
            return null;
        }

        if (!tourService.hasAvailability(tour, adults, children)) {
            return null;
        }

        double totalAmount = tour.calculatePrice(adults, children);
        if (totalAmount <= 0) {
            return null;
        }

        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setParticipants_data(participantsData);
        booking.setBooking_date(new Date());
        booking.setAmount(totalAmount);
        booking.setAdults(adults);
        booking.setChildren(children);
        booking.setStatus(BookingStatus.IN_PROCESS);

        tourService.updateAvailability(tour, adults, children);

        booking = bookingRepository.save(booking);

        booking.setStatus(BookingStatus.BOOKED);
        bookingRepository.save(booking);

        return BookingMapper.toDTO(booking);
    }

    @Transactional
    public BookingDTO cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            // Update booking status to cancelled
            booking.setStatus(BookingStatus.CANCELLED);
            bookingRepository.save(booking);

            // Update tour availability
            Tour tour = booking.getTour();
            int adults = booking.getAdults();
            int children = booking.getChildren();
            tourService.updateAvailability(tour, -adults, -children);
        }
        return null;
    }

    public List<BookingDTO> getAllBookings() {
        return getAllBookings();
    }

    public BookingDTO getBookingById(Long id) {
        return getBookingById(id);
    }
}
