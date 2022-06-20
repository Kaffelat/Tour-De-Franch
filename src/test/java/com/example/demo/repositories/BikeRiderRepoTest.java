package com.example.demo.repositories;

import com.example.demo.entities.BikeRider;
import com.example.demo.entities.BikeTeam;
import com.example.demo.services.BikeRiderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BikeRiderRepoTest {
   @Autowired
   BikeRiderRepo bikeRiderRepo;

   @Autowired
   BikeTeamRepo bikeTeamRepo;


    @BeforeEach
    void setUp(){
        bikeRiderRepo.deleteAll();
        BikeRider test1 = new BikeRider("tester1", 22,2,2,2);
        BikeRider test2 = new BikeRider("tester2", 33,3,3,3);
        BikeTeam bikeTeamTest1 = new BikeTeam("testTeam");

        bikeTeamTest1.addBikeRiders(Set.of(test1,test2));
        bikeTeamRepo.save(bikeTeamTest1);
    }

    @Test
    void addBikeRider(){
        BikeRider testBikeRider = new BikeRider("tester1", 22,2,2,2);
        bikeRiderRepo.save(testBikeRider);
        assertEquals(3,bikeRiderRepo.count());
    }

    @Test
    void editBikeRider(){
    BikeRider bikeRiderTest = bikeRiderRepo.findById(1);
    bikeRiderTest.setName("jeg er ændret");
    bikeRiderRepo.save(bikeRiderTest);
    assertEquals(2,bikeRiderRepo.count());
    assertEquals("jeg er ændret", bikeRiderRepo.findById(1).getName());
    }

    @Test
    void getBikeRiders(){
        List<BikeRider> bikeRiders = bikeRiderRepo.findAll();
        assertEquals(2,bikeRiders.size());
    }

}