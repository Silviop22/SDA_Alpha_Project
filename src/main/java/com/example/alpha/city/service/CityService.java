package com.example.alpha.city.service;

import com.example.alpha.city.mapper.CityMapper;
import com.example.alpha.city.model.City;
import com.example.alpha.city.model.CityDTO;
import com.example.alpha.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        return CityMapper.toDTO(city);
    }

    public CityDTO createCity(CityDTO cityDTO) {
        City city = CityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(city);
        return CityMapper.toDTO(savedCity);
    }

    public CityDTO updateCity(Long id, CityDTO cityDTO) {

        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        existingCity.setName(cityDTO.getName());
        existingCity.setNationality(cityDTO.getNationality());
        City updatedCity = cityRepository.save(existingCity);
        return CityMapper.toDTO(updatedCity);
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new RuntimeException("City not found with id: " + id);
        }
        cityRepository.deleteById(id);
    }
}
