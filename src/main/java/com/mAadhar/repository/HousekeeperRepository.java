package com.mAadhar.repository;

import com.mAadhar.bean.Housekeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousekeeperRepository extends JpaRepository<Housekeeper, String> {
}
