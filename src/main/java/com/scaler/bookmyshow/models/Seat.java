package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @ManyToOne
    private SeatType seatType;

    private int row;
    private int column;

    @ManyToOne
    private SeatStatus seatStatus;

}
