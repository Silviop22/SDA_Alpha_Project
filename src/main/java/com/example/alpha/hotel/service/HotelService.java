package com.example.alpha.hotel.service;

import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.hotel.model.HotelDTO;
import com.example.alpha.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
        private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDTO> getAllHotels() {
            return hotelRepository.findAll().stream()
                    .map(HotelMapper::toDTO)
                    .collect(Collectors.toList());
        }
        public HotelDTO getHotelById(Long id) {
            Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
            return HotelMapper.toDTO(hotel);
        }
        public HotelDTO createHotel(HotelDTO hotelDTO) {
            Hotel hotel = HotelMapper.toEntity(hotelDTO);
            Hotel savedHotel = hotelRepository.save(hotel);
            return HotelMapper.toDTO(savedHotel);
        }
        public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
            Hotel existingHotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
            existingHotel.setCity(hotelDTO.getCity());
            existingHotel.setName (hotelDTO.getName());
            existingHotel.setDescription(hotelDTO.getDescription());
            existingHotel.setStandard(hotelDTO.getStandard());
            Hotel updatedHotel = hotelRepository.save(existingHotel);
            return HotelMapper.toDTO(updatedHotel);
        }
        public void deleteHotel(Long id) {
            hotelRepository.deleteById(id);
        }


    }
