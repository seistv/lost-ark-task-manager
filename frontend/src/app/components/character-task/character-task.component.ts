import { Component, OnInit } from '@angular/core';
import { CharacterTaskService } from '../../services/character-task.service';
import { CharacterTask } from '../../models/character-task';
import { IngameCharacterService } from '../../services/ingame-character.service';
import { IngameCharacter } from '../../models/ingame-character';

@Component({
  selector: 'app-character-task',
  templateUrl: './character-task.component.html',
  styleUrl: './character-task.component.scss'
})
export class CharacterTaskComponent implements OnInit {
  ingameCharacters: IngameCharacter[] = [];     // All characters
  userCharacters: IngameCharacter[] = [];       // Logged in user characters
  tasks: CharacterTask[] = [];                  // All tasks
  userCharactersTasks: CharacterTask[] = [];    // Filtered tasks based on logged in user
  uniqueTasks: string[] = [];                   // Unique task names
  uniqueRaids: string[] = [];                   // Unique raid names

  constructor(private ingameCharacterService: IngameCharacterService, 
              private characterTaskService: CharacterTaskService) {}

  ngOnInit() {
    // Fetch data when the component loads
    this.fetchData();
  }

  fetchData() {
    // Fetch all characters
    this.ingameCharacterService.getIngameCharacters().subscribe(data => {
      this.ingameCharacters = data;
      
      // Fetch user characters
      this.userCharacters = data.filter(userCharacter => userCharacter.userId === 1);
  
      // Fetch all character tasks
      this.characterTaskService.getCharacterTasks().subscribe(tasksData => {
        this.tasks = tasksData;
  
        // Filter user characters tasks
        this.userCharactersTasks = this.tasks.filter(task =>
          this.userCharacters.some(userCharacter => userCharacter.characterId === task.characterId)
        );
  
        // Fetch unique tasks (Daily and Weekly)
        this.uniqueTasks = tasksData
          .filter(
            (task, index, self) =>
              (task.taskType === "Daily" || task.taskType === "Weekly") &&
              index === self.findIndex(t => t.taskName === task.taskName)
          )
          .map(task => task.taskName);
  
        // Fetch unique raids
        this.uniqueRaids = tasksData
          .filter(
            (raid, index, self) =>
              raid.taskType === "Weekly Raid" &&
              index === self.findIndex(t => t.taskName === raid.taskName)
          )
          .map(raid => raid.taskName);
      });
    });
  }

  getCharacterTaskStatus(taskName: string, characterId: number) {
    // Find the task for the given raid and character
    const characterTask = this.userCharactersTasks.find(task =>
      task.taskName === taskName && task.characterId === characterId
    );

    // Return task or an empty object (fallback) to avoid undefined
    return characterTask || { taskType: '', completed: false };  // Default empty task if not found
  }
  
}
