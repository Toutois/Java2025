package com.dronesim.model;

public class DroneOverview {
   private final Drone drone;
   private final DroneType type;
   private final DroneDynamics  dynamics;

   public DroneOverview(Drone drone, DroneType type, DroneDynamics dynamics) {
    this.drone = drone;
    this.type = type;
    this.dynamics = dynamics;
   }

   public Drone getDrone() {
    return drone;
   }

   public DroneType getType() {
    return type;
   }

   public DroneDynamics getDynamics() {
    return dynamics;
   }
}
