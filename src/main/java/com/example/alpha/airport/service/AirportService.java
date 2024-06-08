package com.example.alpha.airport.service;

import com.example.alpha.airport.model.Airport;
import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.airport.repository.AirportRepository;
import com.example.alpha.airport.mapper.AirportMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;


    @Autowired
    private AirportMapper airportMapper;

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(airportMapper::toDTO)
                .collect(Collectors.toList());
    }



    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id).orElse(null);
        if (airport != null) {
            return airportMapper.toDTO(airport);
        } else {
            // Handle case where airport is not found
            return null;
        }
    }

    public AirportDTO createAirport(AirportDTO airportDTO) {
        Airport airport = airportMapper.toEntity(airportDTO);
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.toDTO(savedAirport);
    }

    public AirportDTO updateAirport(Long id, AirportDTO airportDTO) {
        Airport existingAirport = airportRepository.findById(id).orElse(null);
        if (existingAirport != null) {
            Airport updatedAirport = airportMapper.toEntity(airportDTO);
            updatedAirport.setId(id); // Ensure ID consistency
            Airport savedAirport = airportRepository.save(updatedAirport);
            return airportMapper.toDTO(savedAirport);
        } else {
            // Handle case where airport is not found
            return null;
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }}