package com.seistv.lostarktaskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.GoldEarningRaid;
import com.seistv.lostarktaskmanager.model.Raid;

@Repository
public interface GoldEarningRaidRepository extends JpaRepository<GoldEarningRaid, Long> {
	
    @Query("SELECT r FROM Raid r JOIN GoldEarningRaid g ON r.raidId = g.raidId WHERE g.userId = :userId")
    List<Raid> findRaidsByUserId(@Param("userId") Long userId);
    
}