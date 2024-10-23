package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel{
    private String spotNumber;
    private ParkingSpotStatus status;
    private List<VehicleType> supportedVehicleTypes;
    private Long parkingFloorId;
}
