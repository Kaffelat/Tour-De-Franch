package com.example.demo.api;


import com.example.demo.dto.BikeRiderResponse;
import com.example.demo.entities.BikeRider;
import com.example.demo.services.BikeRiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/bikeRiders")
public class BikeRiderController {
    BikeRiderService bikeRiderService;
    public BikeRiderController(BikeRiderService bikeRiderService){
        this.bikeRiderService = bikeRiderService;
    }

    @GetMapping
    public List<BikeRiderResponse> getAllBikeRiders(@RequestParam(value="bikeTeam", required = false) String name){
        return bikeRiderService.getAllBikeRiders(name);

    }
}
