package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }
    public List<Theatre> getTheatres(Long cityId){
        return theatreRepository.findAllByCity_Id(cityId);
    }
}
