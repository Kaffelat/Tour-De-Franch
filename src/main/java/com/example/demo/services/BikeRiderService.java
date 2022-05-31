package com.example.demo.services;

import com.example.demo.dto.BikeRiderRequest;
import com.example.demo.dto.BikeRiderResponse;
import com.example.demo.entities.BikeRider;
import com.example.demo.error.Client4xxException;
import com.example.demo.repositories.BikeRiderRepo;
import com.example.demo.repositories.BikeTeamRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public BikeRiderResponse addBikeRider(BikeRider body){
      bikeRiderRepo.save(body);
      return new BikeRiderResponse(body);
    }

    public void deleteBikeRider(int id){
        BikeRider br = bikeRiderRepo.findById(id);
        bikeRiderRepo.delete(br);
    }

    public BikeRiderResponse editBikeRider(BikeRiderRequest body, int id){
        BikeRider editedBikeRider = bikeRiderRepo.findById(id);
        editedBikeRider.setName(body.getName());
        editedBikeRider.setAge(body.getAge());
        editedBikeRider.setMountainPoints(body.getMountainPoints());
        editedBikeRider.setSprintPoints(body.getSprintPoints());
        editedBikeRider.setTimeInMinutes(body.getTimeInMinutes());
        editedBikeRider.setBikeTeam(bikeTeamRepo.findById(body.getBikeTeamId()));
        return new BikeRiderResponse(bikeRiderRepo.save(editedBikeRider));

    }
}
