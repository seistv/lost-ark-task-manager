package com.seistv.lostarktaskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seistv.lostarktaskmanager.model.UserCharacter;
import com.seistv.lostarktaskmanager.repository.UserCharacterRepository;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    @Autowired
    private UserCharacterRepository userCharacterRepository;

    @GetMapping
    public List<UserCharacter> getAllCharacters() {
        return userCharacterRepository.findAll();
    }

    @PostMapping
    public UserCharacter createCharacter(@RequestBody UserCharacter character) {
        return userCharacterRepository.save(character);
    }
}