package dev.kamal.design_parking_lot.repositries;

import dev.kamal.design_parking_lot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gateMap = new TreeMap<>();
    private Long previousGateId = 0L;

    public Optional<Gate> findGateById(Long gateId) {
        if (gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    public Gate save(Gate gate) {
        if (gate.getId() == null) {
            previousGateId += 1;
            gate.setId(previousGateId);
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Gate delete(Gate gate) {
        gateMap.remove(gate.getId());
        return gate;
    }
}
