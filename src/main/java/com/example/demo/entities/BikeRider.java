package com.example.demo.entities;

import com.example.demo.dto.BikeRiderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BikeRider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private int mountainPoints;
    private int sprintPoints;
    private int timeInMinutes;

    @ManyToOne
    private BikeTeam bikeTeam;



    public BikeRider(String name, int age, int mountainPoints, int sprintPoints, int timeInMinutes){
        this.name = name;
        this.age = age;
        this.mountainPoints = mountainPoints;
        this.sprintPoints = sprintPoints;
        this.timeInMinutes = timeInMinutes;

    }

    public BikeRider(BikeRiderRequest body) {
        this.name = body.getName();
        this.age = body.getAge();
        this.mountainPoints = body.getMountainPoints();
        this.sprintPoints = body.getSprintPoints();
        this.timeInMinutes = body.getTimeInMinutes();
        this.bikeTeam = body.getBikeTeam();
    }

}
