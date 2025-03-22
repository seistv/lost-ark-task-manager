package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.Raid;

@Repository
public interface RaidRepository extends JpaRepository<Raid, Long> {

}
