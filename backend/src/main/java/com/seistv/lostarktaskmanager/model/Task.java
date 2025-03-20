package com.seistv.lostarktaskmanager.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_type")
    private String taskType; // "daily" or "weekly"

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "reset_time")
    private Timestamp resetDate;

    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "character_id")
    @JsonIgnore
    private UserCharacter character;

    // Default constructor
    public Task() {}

    // Parameterized constructor
    public Task(Long taskId, String taskName, String taskType, boolean completed, Timestamp resetDate, UserCharacter character) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
        this.completed = completed;
        this.resetDate = resetDate;
        this.character = character;
    }

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Timestamp getResetDate() {
        return resetDate;
    }

    public void setResetDate(Timestamp resetDate) {
        this.resetDate = resetDate;
    }

    public UserCharacter getCharacter() {
        return character;
    }

    public void setCharacter(UserCharacter character) {
        this.character = character;
    }
}