package dev.kamal.design_parking_lot.services.strategies.spotAssignment;

import dev.kamal.design_parking_lot.models.Gate;
import dev.kamal.design_parking_lot.models.ParkingSpot;
import dev.kamal.design_parking_lot.models.VehicleType;
import dev.kamal.design_parking_lot.repositries.ParkingSpotRepository;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate,
                           ParkingSpotRepository parkingRepository);
}
