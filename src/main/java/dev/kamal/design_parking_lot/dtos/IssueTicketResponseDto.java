package dev.kamal.design_parking_lot.dtos;

import dev.kamal.design_parking_lot.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
