package com.seistv.lostarktaskmanager.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seistv.lostarktaskmanager.model.CharacterTask;
import com.seistv.lostarktaskmanager.repository.CharacterTaskRepository;
import com.seistv.lostarktaskmanager.service.CharacterTaskService;

@Service
public class CharacterTaskServiceImpl implements CharacterTaskService {
	
    private final CharacterTaskRepository characterTaskRepository;
    
    public CharacterTaskServiceImpl(CharacterTaskRepository characterTaskRepository) {
    	this.characterTaskRepository = characterTaskRepository;
    }

	@Override
	public List<CharacterTask> getAllCharacterTasks() {
		return characterTaskRepository.findAll(Sort.by(Sort.Direction.ASC, "taskId"));
	}

}