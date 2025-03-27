package com.seistv.lostarktaskmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.CharacterTask;
import com.seistv.lostarktaskmanager.repository.CharacterTaskRepository;

@RestController
@RequestMapping("/api")
public class CharacterTaskController {
	
    @Autowired
    private CharacterTaskRepository characterTaskRepository;

    @GetMapping("/character-tasks")
    public List<CharacterTask> getAllCharacterTasks() {
    	return characterTaskRepository.findAll();
    }
}