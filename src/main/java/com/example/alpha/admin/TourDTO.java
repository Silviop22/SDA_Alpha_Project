package com.example.alpha.admin;

public class TourDTO {
    private Long id;
    private String name;
    private String description;
    private int standard;
    private double price;

    public long getId (){
        return id ;
    }
    public String getName(){
        return name ;
    }
    public String getDescription(){
        return description;
    }
    public int getStandard(){
        return standard ;

    }
    public double getPrice (){
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

