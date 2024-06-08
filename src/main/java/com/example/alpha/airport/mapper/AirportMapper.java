package com.example.alpha.airport.mapper;

import com.example.alpha.airport.model.Airport;
import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.city.model.City;

public class AirportMapper {
    public AirportDTO toDTO(Airport airport) {
        AirportDTO DTO = new AirportDTO();
        DTO.setId(airport.getId());
        DTO.setName(airport.getName());
        return DTO;
    }

    public static Airport toEntity(AirportDTO DTO) {
        Airport airport = new Airport();
        airport.setId(DTO.getId());
        airport.setName(DTO.getName());
        return airport;
    }
}