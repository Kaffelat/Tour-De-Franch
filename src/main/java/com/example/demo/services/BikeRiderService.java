package com.example.demo.services;

import com.example.demo.dto.BikeRiderResponse;
import com.example.demo.entities.BikeRider;
import com.example.demo.repositories.BikeRiderRepo;
import com.example.demo.repositories.BikeTeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeRiderService {
    BikeRiderRepo bikeRiderRepo;
    BikeTeamRepo bikeTeamRepo;

    public BikeRiderService(BikeRiderRepo bikeRiderRepo, BikeTeamRepo bikeTeamRepo) {
        this.bikeRiderRepo = bikeRiderRepo;
        this.bikeTeamRepo = bikeTeamRepo;
    }

    public List<BikeRiderResponse> getAllBikeRiders(String name){
        List<BikeRider> bikeRiders;
        if (name != null) {
            bikeRiders = bikeRiderRepo.findBikeRiderByBikeTeam_Name(name);
        } else {
            bikeRiders = bikeRiderRepo.findAll();
        }
        return bikeRiders.stream().map(BikeRiderResponse::new).collect(Collectors.toList());
    }
}
