package com.example.alpha.admin;

import com.example.alpha.booking.model.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/bookings")
    public List<BookingDTO> getAllBookings() {
        return adminService.getAllBookings();
    }

    @GetMapping("/bookings/status")
    public ResponseEntity<BookingStatusDTO> getBookingStatus() {
        return ResponseEntity.ok(adminService.getBookingStatus());
    }

    @PostMapping("/tours")
    public TourDTO createTour(@RequestBody TourDTO tourDTO) {
        return adminService.createTour(tourDTO);
    }

    @PutMapping("/tours/{id}")
    public TourDTO updateTour(@PathVariable Long id, @RequestBody TourDTO tourDTO) {
        return adminService.updateTour(id, tourDTO);
    }

    @DeleteMapping("/tours/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        adminService.deleteTour(id);
        return ResponseEntity.ok().build();
    }
}