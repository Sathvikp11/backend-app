package com.mAadhar.service;

import com.mAadhar.bean.Housekeeper;
import com.mAadhar.repository.HousekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousekeeperService {
    private final HousekeeperRepository housekeeperRepository;

    @Autowired
    public HousekeeperService(HousekeeperRepository housekeeperRepository) {
        this.housekeeperRepository = housekeeperRepository;
    }

    public List<Housekeeper> getAllHousekeepers() {
        return housekeeperRepository.findAll();
    }

    public Optional<Housekeeper> getHousekeeperById(String workerId) {
        return housekeeperRepository.findById(workerId);
    }

    public Housekeeper saveHousekeeper(Housekeeper housekeeper) {
        return housekeeperRepository.save(housekeeper);
    }

    public void deleteHousekeeper(String workerId) {
        housekeeperRepository.deleteById(workerId);
    }
}
