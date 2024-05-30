package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    City findAllById(Long id);
}
