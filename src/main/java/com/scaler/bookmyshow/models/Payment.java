package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    //@ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;

    private Date timeOfPayment;
    private double amount;
    private String referenceId;

    //@ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;
}
// 1      - 1
//Payment - Ticket -> M:1
//  M        1