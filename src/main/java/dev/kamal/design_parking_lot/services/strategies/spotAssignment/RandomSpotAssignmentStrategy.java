package dev.kamal.design_parking_lot.services.strategies.spotAssignment;

import dev.kamal.design_parking_lot.models.Gate;
import dev.kamal.design_parking_lot.models.ParkingSpot;
import dev.kamal.design_parking_lot.models.ParkingSpotStatus;
import dev.kamal.design_parking_lot.models.VehicleType;
import dev.kamal.design_parking_lot.repositries.ParkingSpotRepository;

import java.util.Optional;
import java.util.Random;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate,
                                  ParkingSpotRepository parkingRepository) {
        Optional<ParkingSpot> parkingSpotOptional = Optional.empty();
        do {
            Random random = new Random();
            int spotNumber = random.nextInt(10) + 1;
            char spotChar = (char) (random.nextInt(26) + 'A');
            String spotStr = spotChar + String.valueOf(spotNumber);
            int floorNumber = random.nextInt(10) + 1;
            parkingSpotOptional = parkingRepository.findParkingSpotBySpotNumberAndFloorId(spotStr, (long) floorNumber);
        } while (parkingSpotOptional.isEmpty() || parkingSpotOptional.get().getStatus()== ParkingSpotStatus.OCCUPIED);
        ParkingSpot parkingSpot = parkingSpotOptional.get();
        parkingSpot.setStatus(ParkingSpotStatus.OCCUPIED);
        return parkingSpot;
    }
}
