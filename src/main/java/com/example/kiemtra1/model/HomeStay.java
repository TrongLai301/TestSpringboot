package com.example.kiemtra1.model;

import javax.persistence.*;

@Entity
public class HomeStay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Max
    private int numberOfRooms;
    private double price;
    private int numberOfBathrooms;
    private String description;

    @ManyToOne
    private City city;

    public HomeStay(int id, String name, int numberOfRooms, double price, int numberOfBathrooms, String description, City city) {
        this.id = id;
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.numberOfBathrooms = numberOfBathrooms;
        this.description = description;
        this.city = city;
    }
    public HomeStay(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
