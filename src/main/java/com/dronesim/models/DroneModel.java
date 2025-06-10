package com.dronesim.models;

public class DroneModel {

    private int id;
    private String manufacturer;
    private String model;
    private double maxSpeed;

    public DroneModel(int id, String manufacturer, String model, double maxSpeed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public DroneModel() {
        // Für JSON Bibliotheken.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "DroneModel{"
                + "id=" + id
                + ", manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\''
                + ", maxSpeed=" + maxSpeed
                + '}';
    }

}
