package com.mAadhar.controller;

import com.mAadhar.bean.Housekeeper;
import com.mAadhar.service.HousekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/housekeepers")
@CrossOrigin
public class HousekeeperController {
    private final HousekeeperService housekeeperService;
//    GET request to retrieve all housekeepers: /housekeepers
//    GET request to retrieve a housekeeper by workerId: /housekeepers/{workerId}
//    POST request to create a new housekeeper: /housekeepers
//    PUT request to update a housekeeper by workerId: /housekeepers/{workerId}
//    DELETE request to delete a housekeeper by workerId: /housekeepers/{workerId}
    @Autowired
    public HousekeeperController(HousekeeperService housekeeperService) {
        this.housekeeperService = housekeeperService;
    }

    @GetMapping
    public List<Housekeeper> getAllHousekeepers() {
        return housekeeperService.getAllHousekeepers();
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Housekeeper> getHousekeeperById(@PathVariable String workerId) {
        Optional<Housekeeper> housekeeper = housekeeperService.getHousekeeperById(workerId);
        return housekeeper.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Housekeeper createHousekeeper(@RequestBody Housekeeper housekeeper) {
        return housekeeperService.saveHousekeeper(housekeeper);
    }

    @PutMapping("/{workerId}")
    public ResponseEntity<Housekeeper> updateHousekeeper(@PathVariable String workerId, @RequestBody Housekeeper updatedHousekeeper) {
        Optional<Housekeeper> existingHousekeeper = housekeeperService.getHousekeeperById(workerId);
        if (existingHousekeeper.isPresent()) {
            updatedHousekeeper.setWorkerId(workerId);
            Housekeeper savedHousekeeper = housekeeperService.saveHousekeeper(updatedHousekeeper);
            return ResponseEntity.ok(savedHousekeeper);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<Void> deleteHousekeeper(@PathVariable String workerId) {
        Optional<Housekeeper> housekeeper = housekeeperService.getHousekeeperById(workerId);
        if (housekeeper.isPresent()) {
            housekeeperService.deleteHousekeeper(workerId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
