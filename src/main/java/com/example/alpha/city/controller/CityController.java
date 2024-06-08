package com.example.alpha.city.controller;

import com.example.alpha.city.model.CityDTO;
import com.example.alpha.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping
    
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityService. getAllCities ();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity< CityDTO > getCityById(@PathVariable Long id) {
        CityDTO city = cityService.getCityById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity< CityDTO > createCity(@RequestBody CityDTO cityDTO) {
        CityDTO createCity = cityService. createCity (cityDTO);
        return new ResponseEntity<>( createCity, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity< CityDTO > updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        CityDTO updateCity = cityService. updateCity (id, cityDTO);
        return new ResponseEntity<>(updateCity, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
