package com.dronesim.model;

/**
 * Represents an individual drone instance in the drone simulation system. Holds
 * data such as ID, serial number, model, cargo weight, status, and last seen
 * time.
 */
public class Drone {

    // Unique id for the drone
    private int id;

    // The type of drone
    private String dronetype;

    // Creation date of the drone
    private String created;

    // Manufacturer-assigned serial number
    private String serialNumber;

    // Weight of the cargo being carried, in kg
    private int carriage_weight;

    // Type of the carriage
    private String carriage_type;

    // Full constructor – used when creating a drone object with all data
    public Drone(int id, String dronetype, String created, String serialNumber, int carriage_weight, String carriage_type) {
        this.id = id;
        this.dronetype = dronetype;
        this.created = created;
        this.serialNumber = serialNumber;
        this.carriage_weight = carriage_weight;
        this.carriage_type = carriage_type;

    }

    // Default constructor – required for JSON libraries
    public Drone() {

    }

    // Getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDronetype() {
        return dronetype;
    }

    public void setDronetype(String dronetype) {
        this.dronetype = dronetype;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getCarriage_weight() {
        return carriage_weight;
    }

    public void setCarriage_weight(int carriage_weight) {
        this.carriage_weight = carriage_weight;
    }

    public String getCarriage_type() {
        return carriage_type;
    }

    public void setCarriage_type(String carriage_type) {
        this.carriage_type = carriage_type;
    }

    @Override
    public String toString() {
        return "Drone{"
                + "id=" + id
                + ", dronetype='" + dronetype + '\''
                + ", created='" + created + '\''
                + ", serialNumber='" + serialNumber + '\''
                + ", carriage_weight=" + carriage_weight
                + ", carriage_type='" + carriage_type + '\''
                + '}';

    }

}