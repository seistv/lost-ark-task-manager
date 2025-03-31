package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.IngameCharacter;

@Repository
public interface IngameCharacterRepository extends JpaRepository<IngameCharacter, Integer> {

}