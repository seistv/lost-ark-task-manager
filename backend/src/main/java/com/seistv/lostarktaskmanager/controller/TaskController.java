package com.seistv.lostarktaskmanager.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.Raid;
import com.seistv.lostarktaskmanager.model.Task;
import com.seistv.lostarktaskmanager.repository.GoldEarningRaidRepository;
import com.seistv.lostarktaskmanager.repository.RaidRepository;
import com.seistv.lostarktaskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RaidRepository raidRepository;

    @Autowired
    private GoldEarningRaidRepository goldEarningRaidRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PutMapping("/tasks/update-status")
    public ResponseEntity<Map<String, String>> updateTaskStatus(@RequestBody Map<String, Object> payload) {
        Long taskId = ((Number) payload.get("taskId")).longValue();
        boolean completed = (boolean) payload.get("completed");

        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(completed);
            taskRepository.save(task);
            
            // ✅ Return JSON response instead of a plain string
            Map<String, String> response = new HashMap<>();
            response.put("message", "Task status updated successfully.");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Task not found."));
        }
    }

    // Fetch all raids
    @GetMapping("/raids")
    public List<Raid> getAllRaids() {
        return raidRepository.findAll();
    }

    // Fetch gold-earning raids for a user
    @GetMapping("/gold-earning-raids/{userId}")
    public List<Raid> getGoldEarningRaids(@PathVariable Long userId) {
        return goldEarningRaidRepository.findRaidsByUserId(userId);
    }
}