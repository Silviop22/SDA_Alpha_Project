package com.example.alpha.tour.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String city;
    private String hotel;
    private String airport;

    private String description ;

    private int standard ;
    private Double price ;

    // Constructors
    public Tour() {
    }
    public Tour(String name,String city, String hotel, String airport, String description, int standard ,Double price) {
        this.city = city;
        this.hotel = hotel;
        this.airport = airport;
        this.description = description ;
        this.standard = standard ;
        this.price = price ;
        this.name= name;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getHotel() {
        return hotel;
    }
    public void setHotel(String hotel) {

        this.hotel = hotel;
    }

    public String getAirport() {

        return airport;
    }
    public void setAirport(String airport) {
        this.airport = airport;
    }

    public void setChild_places_available(int i) {
        this.setChild_places_available(i);
    }

    public void setAdult_seats_available(int i) {
        this.setAdult_seats_available(i);
    }

    public int getChild_places_available() {
    return getChild_places_available();
    }

    public int getAdult_seats_available() {
    return getAdult_seats_available();
    }

    public double calculatePrice(int adults, int children) {
        double totalPrice = (getPrice_adult() * adults) + (getPrice_child() * children);
        return totalPrice;
    }

    private double getPrice_child() {
        return getPrice_adult();
    }

    private double getPrice_adult() {
        return getPrice_adult();
    }

    public Long getTour_id() {
        return getTour_id();
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription (){
        return  description ;
    }

    public void setStandard(int standard) {
        this.standard = standard ;

    }
    public int getStandard(){
        return  standard ;
    }

    public void setPrice(double price) {
        this.price=price ;
    }
    public Double getPrice(){
        return  price ;
    }

    public void setName(String name) {
this.name=name;

    }
    public String getName(){
        return name;
    }
}