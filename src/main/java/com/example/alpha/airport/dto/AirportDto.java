package com.example.alpha.airport.dto;

public class AirportDto {
    private Long id;
    private String name;
    private Long designatedCityId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDesignatedCityId() {
        return designatedCityId;
    }

    public void setDesignatedCityId(Long designatedCityId) {
        this.designatedCityId = designatedCityId;
    }
}