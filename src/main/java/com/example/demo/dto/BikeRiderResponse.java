package com.example.demo.dto;

import com.example.demo.entities.BikeRider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BikeRiderResponse {
    private int id;

    private String name;
    private int age;
    private int timeInMinutes;
    private int mountainPoints;
    private int sprintPoints;

    private int bikeTeamId;
    private String bikeTeamName;


    public BikeRiderResponse (BikeRider body){
        this.id = body.getId();
        this.name = body.getName();
        this.age = body.getAge();
        this.mountainPoints = body.getMountainPoints();
        this.sprintPoints = body.getSprintPoints();
        this.timeInMinutes = body.getTimeInMinutes();
        this.bikeTeamName = body.getBikeTeam().getBikeTeamName();
        this.bikeTeamId = body.getBikeTeam().getId();
    }
}
