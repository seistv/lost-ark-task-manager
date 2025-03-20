package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.UserCharacter;

@Repository
public interface UserCharacterRepository extends JpaRepository<UserCharacter, Long> {

}