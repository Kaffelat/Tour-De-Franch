package com.example.demo.dto;

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
    private int bikeTeamId;


}
