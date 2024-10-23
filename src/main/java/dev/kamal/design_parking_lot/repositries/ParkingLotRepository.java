package dev.kamal.design_parking_lot.repositries;

import dev.kamal.design_parking_lot.models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();
    private Long previousParkingLotId = 0L;

    public ParkingLot findParkingLotById(Long previousParkingLotId) {
        return parkingLotMap.get(previousParkingLotId);
    }

    public ParkingLot save(ParkingLot parkingLot) {
        if (parkingLot.getId() == null) {
            previousParkingLotId += 1;
            parkingLot.setId(previousParkingLotId);
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
