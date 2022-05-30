package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BikeTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "bikeTeam", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    private Set<BikeRider> ridersOfATeam = new HashSet<>();

    public BikeTeam(String name){
        this.name = name;
    }

    public void addCandidate(BikeRider bikeRider){
        this.ridersOfATeam.add(bikeRider);
        bikeRider.setBikeTeam(this);
    }

    public void addCandidates(Set<BikeRider> bikeRiders){
        this.ridersOfATeam.addAll(bikeRiders);
        for (BikeRider candidate : ridersOfATeam) {
            candidate.setBikeTeam(this);
        }
    }
}
