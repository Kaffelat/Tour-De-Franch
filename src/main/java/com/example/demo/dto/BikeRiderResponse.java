package com.example.demo.dto;

import com.example.demo.entities.BikeRider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BikeRiderResponse {
    private int id;
    private String name;
    private String bikeTeamName;

    public BikeRiderResponse (BikeRider body){
        this.id = body.getId();
        this.name = body.getName();
        this.bikeTeamName = body.getBikeTeam().getName();
    }
}
