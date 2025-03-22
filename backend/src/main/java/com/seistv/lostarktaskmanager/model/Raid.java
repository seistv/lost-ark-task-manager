package com.seistv.lostarktaskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raids")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raid_id")
    private Long raidId;

    @Column(name = "raid_name")
    private String raidName;

    @Column(name = "raid_type")
    private String raidType; // Legion, Epic, Kazeros

    // Getters and Setters
    public Long getRaidId() {
        return raidId;
    }

    public void setRaidId(Long raidId) {
        this.raidId = raidId;
    }

    public String getRaidName() {
        return raidName;
    }

    public void setRaidName(String raidName) {
        this.raidName = raidName;
    }

    public String getRaidType() {
        return raidType;
    }

    public void setRaidType(String raidType) {
        this.raidType = raidType;
    }
}
