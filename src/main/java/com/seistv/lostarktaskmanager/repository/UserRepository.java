package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}