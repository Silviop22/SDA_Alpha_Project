package com.example.alpha.airport.model;


import com.example.alpha.city.model.City;
import jakarta.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City designatedCity;

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

    public City getDesignatedCity() {
        return designatedCity;
    }

    public void setDesignatedCity(City designatedCity) {
        this.designatedCity = designatedCity;
    }
}
