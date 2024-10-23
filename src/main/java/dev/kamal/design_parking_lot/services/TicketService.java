package dev.kamal.design_parking_lot.services;

import dev.kamal.design_parking_lot.exceptions.GateNotFoundException;
import dev.kamal.design_parking_lot.models.*;
import dev.kamal.design_parking_lot.repositries.*;
import dev.kamal.design_parking_lot.services.factory.SpotAssignmentStrategyFactory;
import dev.kamal.design_parking_lot.services.strategies.spotAssignment.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;


    public TicketService(GateRepository gateRepository,
                         TicketRepository ticketRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         ParkingSpotRepository parkingSpotRepository){

        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket issueTicket(Long gateId,
                              String vehicleNumber,
                              VehicleType vehicleType,
                              String ownerName) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        // findGateById
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if(optionalGate.isEmpty()){
            throw new GateNotFoundException("Gate not Found with id: " + gateId);
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        // Get the vehicle object with number
        // If vehicle not found, create a new vehicle object
        // and save it in the vehicle repository
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle = null;
        if (optionalVehicle.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(vehicle);
        } else {
            savedVehicle = optionalVehicle.get();
        }

        ticket.setVehicle(savedVehicle);

        // assign the spot to the vehicle
        Long parkingLotId = gate.getParkingLot().getId();
        ParkingLot parkingLot = parkingLotRepository.findParkingLotById(parkingLotId);
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.
                getSpotAssignmentStrategy(spotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate, parkingSpotRepository);
        ticket.setParkingSpot(parkingSpot);
        // Set a random alphanumeric string for the ticket
        ticket.setTickedNumber(RandomStringGenerationService.generateRandomAlphanumericString());
        return ticketRepository.save(ticket);

    }

}
