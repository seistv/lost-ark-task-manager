package com.seistv.lostarktaskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gold_earning_raids")
public class GoldEarningRaid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gold_earning_id")
    private Long goldEarningId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "raid_id")
    private Long raidId;

    // Getters and Setters
    public Long getGoldEarningId() {
        return goldEarningId;
    }

    public void setGoldEarningId(Long goldEarningId) {
        this.goldEarningId = goldEarningId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRaidId() {
        return raidId;
    }

    public void setRaidId(Long raidId) {
        this.raidId = raidId;
    }
}