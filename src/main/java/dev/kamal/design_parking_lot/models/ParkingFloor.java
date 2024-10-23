package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private ParkingFloorStatus status;
    private List<ParkingSpot> parkingSpots;
}
