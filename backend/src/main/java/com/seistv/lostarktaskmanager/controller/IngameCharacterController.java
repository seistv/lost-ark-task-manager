package com.seistv.lostarktaskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.IngameCharacter;
import com.seistv.lostarktaskmanager.service.IngameCharacterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class IngameCharacterController {
	
    private final IngameCharacterService ingameCharacterService;
    
    public IngameCharacterController(IngameCharacterService ingameCharacterService) {
    	this.ingameCharacterService = ingameCharacterService;
    }

    @GetMapping("/ingame-characters")
    public List<IngameCharacter> getAllIngameCharacters() {
        return ingameCharacterService.getAllIngameCharacters();
    }
    
}