package com.seistv.lostarktaskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.CharacterTask;
import com.seistv.lostarktaskmanager.service.CharacterTaskService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CharacterTaskController {
	
    private final CharacterTaskService characterTaskService;
    
    public CharacterTaskController(CharacterTaskService characterTaskService) {
    	this.characterTaskService = characterTaskService;
    }

    @GetMapping("/character-tasks")
    public List<CharacterTask> getAllCharacterTasks() {
    	return characterTaskService.getAllCharacterTasks();
    }
}