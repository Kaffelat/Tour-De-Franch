package com.example.demo.services;

import com.example.demo.entities.BikeTeam;
import com.example.demo.repositories.BikeRiderRepo;
import com.example.demo.repositories.BikeTeamRepo;
import org.springframework.stereotype.Service;

@Service
public class BikeTeamService {
    BikeTeamRepo bikeTeamRepo;

    public BikeTeamService (BikeTeamRepo bikeTeamRepo){
        this.bikeTeamRepo = bikeTeamRepo;
    }

    public BikeTeam findBikerById(int id){
        return bikeTeamRepo.findById(id);
    }
}
