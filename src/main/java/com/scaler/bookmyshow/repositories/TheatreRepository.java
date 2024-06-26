package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    List<Theatre> findAllByCity_Id(Long cityId);
}
