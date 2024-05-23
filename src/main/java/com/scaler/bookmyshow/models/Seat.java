package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    //@ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;
    @Column(name = "col")
    private int column;

    //@ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

}
