package com.example.demo.config;

import com.example.demo.entities.BikeRider;
import com.example.demo.entities.BikeTeam;
import com.example.demo.repositories.BikeRiderRepo;
import com.example.demo.repositories.BikeTeamRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {
    BikeRiderRepo bikeRiderRepo;
    BikeTeamRepo bikeTeamRepo;

    public MakeTestData(BikeRiderRepo bikeRiderRepo, BikeTeamRepo bikeTeamRepo){
        this.bikeRiderRepo = bikeRiderRepo;
        this.bikeTeamRepo = bikeTeamRepo;
    }
    public void makeBikeTeamsWithRiders(){
        BikeTeam bikeTeam1 = new BikeTeam("Team Easy On");
        BikeTeam bikeTeam2 = new BikeTeam("Israel");
        BikeTeam bikeTeam3 = new BikeTeam("Jumbo-Visma");

        BikeRider bikeRider1 = new BikeRider("Bobby Olsen", 22, 3, 1, 300);
        BikeRider bikeRider2 = new BikeRider("Pim de Keysergracht", 30, 6, 10, 600);
        BikeRider bikeRider3 = new BikeRider("Gitte Sebster", 27, 5,2,700);
        BikeRider bikeRider4 = new BikeRider("Goldstein Omer", 19, 8,2,100);
        BikeRider bikeRider5 = new BikeRider("Woods Michael",45, 9,2,200);
        BikeRider bikeRider6 = new BikeRider("Fuglsang Jakob", 65, 10,2,1000);
        BikeRider bikeRider7 = new BikeRider("Vingegaard Jonas", 32, 4,2,3000);
        BikeRider bikeRider8 = new BikeRider("Kuss Sepp",18, 1,2,3500);

        bikeTeam1.addBikeRiders(Set.of(bikeRider1,bikeRider2));
        bikeTeam2.addBikeRider((bikeRider3));
        bikeTeam2.addBikeRiders(Set.of(bikeRider4, bikeRider5));
        bikeTeam3.addBikeRiders(Set.of(bikeRider6, bikeRider7,bikeRider8));

        bikeTeamRepo.saveAll(List.of(
                bikeTeam1,
                bikeTeam2,
                bikeTeam3));

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeBikeTeamsWithRiders();
    }

}
