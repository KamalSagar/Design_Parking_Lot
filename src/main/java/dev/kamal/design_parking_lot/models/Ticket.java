package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel{
    private String tickedNumber; // Random string of 7 characters
    private Date entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Gate entryGate;

}
