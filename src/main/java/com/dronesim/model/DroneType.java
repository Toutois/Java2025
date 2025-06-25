package com.dronesim.model;

/**
 * Represents a drone model definition used by individual drones. Holds data
 * such as ID, manufacturer, model name, and maximum speed.
 */
public class DroneType {

    // Unique ID for the drone model
    private int id;

    // Name of the drone manufacturer
    private String manufacturer;

    // Name or type of the drone (model name or classification)
    private String typename;

    // Weight of the drone in kg
    private int weight;

    // Maximum speed of the drone in km/h
    private int max_speed;

    // Battery capacity in mAh
    private int battery_capacity;

    // Control range in meters
    private int control_range;

    // Maximum carriage capacity in kg
    private int max_carriage;

    // Full constructor – used when creating a drone model with all data
    public DroneType(int id, String manufacturer, String typename, int weight, int max_speed,
            int battery_capacity, int control_range, int max_carriage) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.typename = typename;
        this.weight = weight;
        this.max_speed = max_speed;
        this.battery_capacity = battery_capacity;
        this.control_range = control_range;
        this.max_carriage = max_carriage;
    }

    // Default constructor – required for JSON libraries
    public DroneType() {
    }

    // Getter and setter methods for each attribute
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public int getControl_range() {
        return control_range;
    }

    public void setControl_range(int control_range) {
        this.control_range = control_range;
    }

    public int getMax_carriage() {
        return max_carriage;
    }

    public void setMax_carriage(int max_carriage) {
        this.max_carriage = max_carriage;
    }

    @Override
    public String toString() {
        return "DroneType{"
                + "id=" + id
                + ", manufacturer='" + manufacturer + '\''
                + ", typename='" + typename + '\''
                + ", weight=" + weight
                + ", max_speed=" + max_speed
                + ", battery_capacity=" + battery_capacity
                + ", control_range=" + control_range
                + ", max_carriage=" + max_carriage
                + '}';
    }

}