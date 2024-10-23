package dev.kamal.design_parking_lot.services.factory;

import dev.kamal.design_parking_lot.models.SpotAssignmentStrategyType;
import dev.kamal.design_parking_lot.services.strategies.spotAssignment.CheapestSpotAssignmentStrategy;
import dev.kamal.design_parking_lot.services.strategies.spotAssignment.NearestSpotAssignmentStrategy;
import dev.kamal.design_parking_lot.services.strategies.spotAssignment.RandomSpotAssignmentStrategy;
import dev.kamal.design_parking_lot.services.strategies.spotAssignment.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType){
        switch (spotAssignmentStrategyType){
            case NEAREST:
                return new NearestSpotAssignmentStrategy();
            case CHEAPEST:
                return new CheapestSpotAssignmentStrategy();
            case RANDOM:
                return new RandomSpotAssignmentStrategy();
            default:
                return null;
        }
    }

}
