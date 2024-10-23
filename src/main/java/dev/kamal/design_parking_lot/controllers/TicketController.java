package dev.kamal.design_parking_lot.controllers;

import dev.kamal.design_parking_lot.dtos.IssueTicketRequestDto;
import dev.kamal.design_parking_lot.dtos.IssueTicketResponseDto;
import dev.kamal.design_parking_lot.dtos.ResponseStatus;
import dev.kamal.design_parking_lot.exceptions.GateNotFoundException;
import dev.kamal.design_parking_lot.models.Ticket;
import dev.kamal.design_parking_lot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issureTicket(IssueTicketRequestDto issueTicketRequestDto){
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket =  ticketService.issueTicket(
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getRegistrationNumber(),
                    issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getOwnerName()
            );
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (GateNotFoundException gateNotFoundException){
            System.out.println("Gate not found reason: " + gateNotFoundException.getMessage());
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return issueTicketResponseDto;
    }
}
