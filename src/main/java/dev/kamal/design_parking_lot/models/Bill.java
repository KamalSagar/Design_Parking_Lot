package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Bill extends BaseModel{
    private Ticket ticket;
    private Gate gate;
    private Operator generatedBy;
    private int amount;
    private BillStatus status;
    List<Payment> paymentList;
    private Date exitTime;
}