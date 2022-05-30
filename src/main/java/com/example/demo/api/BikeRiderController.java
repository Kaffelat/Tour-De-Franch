package com.example.demo.api;


import com.example.demo.dto.BikeRiderRequest;
import com.example.demo.dto.BikeRiderResponse;
import com.example.demo.entities.BikeRider;
import com.example.demo.services.BikeRiderService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/bikeRiders")
public class BikeRiderController {
    BikeRiderService bikeRiderService;
    public BikeRiderController(BikeRiderService bikeRiderService){
        this.bikeRiderService = bikeRiderService;
    }

    @GetMapping
    public List<BikeRiderResponse> getAllBikeRiders(@RequestParam(value="bikeTeam", required = false) String name){
        return bikeRiderService.getAllBikeRiders(name);
    }

    @GetMapping("/pageable")
    public List<BikeRiderResponse> getAllBikeRiders(Pageable pageable){
        return bikeRiderService.getAllBikeRiders(pageable);
    }
//localhost:8080/api/cars/pageable?page=0&3
    @PostMapping
    public BikeRiderResponse addBikeRider(@RequestBody BikeRiderRequest body){
        return bikeRiderService.addBikeRider(body);
    }

    @PutMapping(value = "/{id}")
    public BikeRiderResponse editBikeRider(@RequestBody BikeRiderRequest body,@PathVariable int id){
        return bikeRiderService.editBikeRider(body,id);
    }
    @DeleteMapping(value ="/{id}")
    public void deleteBikeRiderByID(@PathVariable int id){
        bikeRiderService.deleteBikeRider(id);
    }
}
