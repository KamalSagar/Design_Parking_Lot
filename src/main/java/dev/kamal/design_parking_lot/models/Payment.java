package dev.kamal.design_parking_lot.models;

import java.util.Date;

public class Payment extends BaseModel{
    private int amount;
    private PaymentStatus status;
    private String transactionId;
    private PaymentMode paymentMode;
    private Bill bill;
    private Date paymentTime;

}
