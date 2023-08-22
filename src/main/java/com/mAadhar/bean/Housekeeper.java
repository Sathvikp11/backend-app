package com.mAadhar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Housekeeper {
    @Id
    @Column(name = "worker_id")
    private String workerId;
    @Column
    private String name;
    @Column
    private String hostel;
    @Column
    private String floor;

    @Column(name = "rooms_cleaned_count")
    private int roomsCleanedCount;

    @Column(name = "complaints_count")
    private int complaintsCount;

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getRoomsCleanedCount() {
        return roomsCleanedCount;
    }

    public void setRoomsCleanedCount(int roomsCleanedCount) {
        this.roomsCleanedCount = roomsCleanedCount;
    }

    public int getComplaintsCount() {
        return complaintsCount;
    }

    public void setComplaintsCount(int complaintsCount) {
        this.complaintsCount = complaintsCount;
    }
}
