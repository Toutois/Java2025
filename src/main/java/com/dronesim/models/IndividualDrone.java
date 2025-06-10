package com.dronesim.models;

public class IndividualDrone {

    private int id;
    private String serialNumber;
    private DroneModel model;
    private double cargoWeight;
    private String status;
    private String lastSeen;

    public IndividualDrone(int id, String serialNumber, DroneModel model, double cargoWeight, String status, String lastSeen) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.cargoWeight = cargoWeight;
        this.status = status;
        this.lastSeen = lastSeen;
    }

    public IndividualDrone() {
        // Für JSON Bibliotheken.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "IndividualDrone{"
                + "id=" + id
                + ", serialNumber='" + serialNumber + '\''
                + ", model=" + (model != null ? model.getModel() : "null")
                + ", cargoWeight=" + cargoWeight
                + ", status='" + status + '\''
                + ", lastSeen='" + lastSeen + '\''
                + '}';
    }

}
