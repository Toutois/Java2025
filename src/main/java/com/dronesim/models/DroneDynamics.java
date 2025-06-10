package com.dronesim.models;

public class DroneDynamics {

    private int id;
    private IndividualDrone droneId;
    private String timestamp;
    private double speed;
    private double alignRoll;
    private double alignPitch;
    private double alignYaw;
    private double longitude;
    private double latitude;
    private double velocity;
    private double battery;
    private String status;

    public DroneDynamics(int id, IndividualDrone droneId, String timestamp, double speed, double alignRoll,
            double alignPitch, double alignYaw, double longitude, double latitude,
            double velocity, double battery, String status) {
        this.id = id;
        this.droneId = droneId;
        this.timestamp = timestamp;
        this.speed = speed;
        this.alignRoll = alignRoll;
        this.alignPitch = alignPitch;
        this.alignYaw = alignYaw;
        this.longitude = longitude;
        this.latitude = latitude;
        this.velocity = velocity;
        this.battery = battery;
        this.status = status;
    }

    public DroneDynamics() {
        // Für JSON Bibliotheken.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IndividualDrone getDroneId() {
        return droneId;
    }

    public void setDroneId(IndividualDrone droneId) {
        this.droneId = droneId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAlignRoll() {
        return alignRoll;
    }

    public void setAlignRoll(double alignRoll) {
        this.alignRoll = alignRoll;
    }

    public double getAlignPitch() {
        return alignPitch;
    }

    public void setAlignPitch(double alignPitch) {
        this.alignPitch = alignPitch;
    }

    public double getAlignYaw() {
        return alignYaw;
    }

    public void setAlignYaw(double alignYaw) {
        this.alignYaw = alignYaw;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DroneDynamics{"
                + "id=" + id
                + ", droneId=" + (droneId != null ? droneId.getSerialNumber() : "null")
                + ", timestamp='" + timestamp + '\''
                + ", speed=" + speed
                + ", alignRoll=" + alignRoll
                + ", alignPitch=" + alignPitch
                + ", alignYaw=" + alignYaw
                + ", longitude=" + longitude
                + ", latitude=" + latitude
                + ", velocity=" + velocity
                + ", battery=" + battery
                + ", status='" + status + '\''
                + '}';
    }
}
