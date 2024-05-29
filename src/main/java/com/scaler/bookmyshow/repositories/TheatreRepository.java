package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    List<Theatre> findAllByCity_Id(Long cityId);
}
