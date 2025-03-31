package com.seistv.lostarktaskmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seistv.lostarktaskmanager.model.IngameCharacter;
import com.seistv.lostarktaskmanager.repository.IngameCharacterRepository;
import com.seistv.lostarktaskmanager.service.IngameCharacterService;

@Service
public class IngameCharacterServiceImpl implements IngameCharacterService {
	
    private final IngameCharacterRepository ingameCharacterRepository;
    
    public IngameCharacterServiceImpl(IngameCharacterRepository ingameCharacterRepository) {
    	this.ingameCharacterRepository = ingameCharacterRepository;
    }

	@Override
	public List<IngameCharacter> getAllIngameCharacters() {
		return ingameCharacterRepository.findAll();
	}
}