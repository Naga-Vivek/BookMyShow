package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity // To create a table for this model class , we use JPA annotation @Entity
@Getter
@Setter
public class Actor extends BaseModel {
    private String name;
    private int age;
}
