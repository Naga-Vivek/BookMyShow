package com.scaler.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass // Schema Design
@Getter
@Setter
//@Entity -> Not required here because we don't want to create the table for BaseModel.
public abstract class BaseModel {
    @Id // @Id - denotes this attribute is a PK of tables corresponding to derived entity classes.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "identity")
    private Long id;
}
