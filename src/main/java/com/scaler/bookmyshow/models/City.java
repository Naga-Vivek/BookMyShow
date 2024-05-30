package com.scaler.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class City extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<Theatre> theatres;
}
// To avoid json infinite recursion for Bidirectional relationships,
// We use @JsonManagedReference with @OneToMany and
//        @JsonBackReference with @ManyToOne