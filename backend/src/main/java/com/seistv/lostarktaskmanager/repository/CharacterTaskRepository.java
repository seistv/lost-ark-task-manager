package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.CharacterTask;

@Repository
public interface CharacterTaskRepository extends JpaRepository<CharacterTask, Integer> {
	
}
