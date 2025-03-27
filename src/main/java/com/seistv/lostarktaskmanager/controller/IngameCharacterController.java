package com.seistv.lostarktaskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.IngameCharacter;
import com.seistv.lostarktaskmanager.repository.IngameCharacterRepository;

@RestController
@RequestMapping("/api")
public class IngameCharacterController {
	
    @Autowired
    private IngameCharacterRepository ingameCharacterRepository;

    @GetMapping("/ingame-characters")
    public List<IngameCharacter> getAllIngameCharacters() {
        return ingameCharacterRepository.findAll();
    }
    
}