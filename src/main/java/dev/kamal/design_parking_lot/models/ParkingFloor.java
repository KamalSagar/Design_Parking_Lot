package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
    private List<ParkingSpot> parkingSpots;

    public String toString() {
        return "ParkingFloor{" +
                "floorId=" + this.getId() +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
