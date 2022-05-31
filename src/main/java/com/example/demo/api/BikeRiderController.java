package com.example.demo.api;


import com.example.demo.dto.BikeRiderRequest;
import com.example.demo.dto.BikeRiderResponse;
import com.example.demo.entities.BikeRider;
import com.example.demo.services.BikeRiderService;
import com.example.demo.services.BikeTeamService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/bikeRiders")
public class BikeRiderController {
    BikeRiderService bikeRiderService;
    BikeTeamService bikeTeamService;

    public BikeRiderController(BikeRiderService bikeRiderService, BikeTeamService bikeTeamService){
        this.bikeRiderService = bikeRiderService;
        this.bikeTeamService = bikeTeamService;
    }

    @GetMapping
    public List<BikeRiderResponse> getAllBikeRiders(@RequestParam(value="bikeTeam", required = false) String name){
        return bikeRiderService.getAllBikeRiders(name);
    }
    @GetMapping("/{bikeTeamName}")
    public List<BikeRiderResponse> getBikeRidersByTeamName(@PathVariable String bikeTeamName){
        return bikeRiderService.getAllBikeRiders(bikeTeamName);
    }

    @PostMapping
    public BikeRiderResponse addBikeRider(@RequestBody BikeRiderRequest body){
        BikeRider bikeRider = new BikeRider(body);
        bikeTeamService.findBikerById(body.getBikeTeamId()).addBikeRider(bikeRider);
        bikeRiderService.addBikeRider(bikeRider);
        return new BikeRiderResponse(bikeRider);
    }

    @PutMapping("/{id}")
    public BikeRiderResponse editBikeRider(@RequestBody BikeRiderRequest body,@PathVariable int id){
        return bikeRiderService.editBikeRider(body,id);
    }
    @DeleteMapping("/{id}")
    public void deleteBikeRiderByID(@PathVariable int id){
        bikeRiderService.deleteBikeRider(id);
    }
}
