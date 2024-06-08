package com.example.alpha.city.mapper;

import com.example.alpha.city.model.City;
import com.example.alpha.city.model.CityDTO;


public class CityMapper {
    public static CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setCityId(city.getId());
        dto.setName(city.getName());
        dto.setNationality(city.getNationality());
        return dto;
    }

    public static City toEntity(CityDTO dto) {
        City city = new City();
        city.setId(dto.getCityId());
        city.setName(dto.getName());
        city.setNationality(dto.getNationality());
        return city;
    }
}
