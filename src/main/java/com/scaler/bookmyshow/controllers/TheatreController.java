package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.services.TheatreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping()
    public ResponseEntity<List<Theatre>> getTheatres(@RequestParam("cityId") Long id){
        List<Theatre> theatres = theatreService.getTheatres(id);
        return ResponseEntity.ok(theatres);
    }

}
// City - Theatre is  1:M  relationship
// Having both City Controller & Theatre Controller APIs to test the bidirectional relationship between city & theatre