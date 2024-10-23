package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel{
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;

}
