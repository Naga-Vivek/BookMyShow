package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 1:M
// 1:1

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    //@ManyToMany
    @ElementCollection // because we have list of features
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
//Relations between the entities :-

//1. Find the cardinality of the relation.
// 1:1 -> Id of one side on other side.
// 1:M OR M:1 -> Id of ONE side on MANY side.
// M:M -> mapping table.

// 1 ----M
//Audi - Seat -> 1 : M
//  1    -  1
// audi_id in seats table.