package com.seistv.lostarktaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seistv.lostarktaskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
