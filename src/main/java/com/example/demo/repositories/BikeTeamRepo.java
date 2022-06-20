package com.example.demo.repositories;

import com.example.demo.entities.BikeRider;
import com.example.demo.entities.BikeTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeTeamRepo extends JpaRepository<BikeTeam, Integer> {
    BikeTeam findById(int id);
    BikeTeam findByBikeTeamName(String bikeTeamName);
}
