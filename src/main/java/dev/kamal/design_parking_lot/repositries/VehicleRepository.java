package dev.kamal.design_parking_lot.repositries;

import dev.kamal.design_parking_lot.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap = new TreeMap<>();
    private Map<String, Vehicle> vehicleNumberMap = new TreeMap<>();
    private Long previousVehicleId = 0L;

    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == null) {
            previousVehicleId += 1;
            vehicle.setId(previousVehicleId);
        }
        vehicleMap.put(vehicle.getId(), vehicle);
        // add it to vehicle number map
        vehicleNumberMap.put(vehicle.getRegistrationNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        if (vehicleNumberMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleNumberMap.get(vehicleNumber));
        }
        return Optional.empty();
    }
}
