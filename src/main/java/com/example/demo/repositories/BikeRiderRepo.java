package com.example.demo.repositories;

import com.example.demo.entities.BikeRider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRiderRepo extends JpaRepository<BikeRider,Integer> {
    List<BikeRider> findBikeRiderByBikeTeam_Name(String name);
    BikeRider findById(int id);
}
