package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
//@Table(name = "users")
public class User extends BaseModel {
    private String email;
}