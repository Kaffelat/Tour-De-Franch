package com.example.demo.dto;

import com.example.demo.entities.BikeTeam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BikeRiderRequest {
    private int id;

    private String name;
    private int age;
    private int mountainPoints;
    private int sprintPoints;
    private int timeInMinutes;

    private String bikeTeamName;
    private BikeTeam bikeTeam;

    public BikeRiderRequest(String name, int age, int mountainPoints, int sprintPoints, int timeInMinutes, String bikeTeamName){
        this.name = name;
        this.age = age;
        this.mountainPoints = mountainPoints;
        this.sprintPoints = sprintPoints;
        this.timeInMinutes = timeInMinutes;
        this.bikeTeamName = bikeTeamName;
    }

    public BikeRiderRequest(String name, int age, int mountainPoints, int sprintPoints, int timeInMinutes, BikeTeam bikeTeam){
        this.name = name;
        this.age = age;
        this.mountainPoints = mountainPoints;
        this.sprintPoints = sprintPoints;
        this.timeInMinutes = timeInMinutes;
        this.bikeTeam = bikeTeam;
    }
}
