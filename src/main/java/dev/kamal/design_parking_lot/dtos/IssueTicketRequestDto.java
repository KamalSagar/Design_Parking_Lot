package dev.kamal.design_parking_lot.dtos;

import dev.kamal.design_parking_lot.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String registrationNumber;
    private String ownerName;
}
