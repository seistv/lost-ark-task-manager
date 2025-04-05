import { Component, OnInit } from '@angular/core';
import { CharacterTaskService } from './services/character-task.service';
import { IngameCharacterService } from './services/ingame-character.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  isDarkMode = false;
  // isLoggedIn = false;
  // tasks: any[] = [];
  // raids: any[] = [];

  // constructor(private characterTaskService: CharacterTaskService, 
  //             private ingameCharacterService : IngameCharacterService
  //           ) {}

  // ngOnInit() {
  //   // Fetch data when the component loads
  //   this.fetchData();
  // }

  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
    document.body.classList.toggle('dark-mode', this.isDarkMode);
  }
  

  // login() {
  //   this.isLoggedIn = true;
  //   this.fetchData(); // Load data after login
  //   console.log("Login successful! isLoggedIn:", this.isLoggedIn);
  // }

  // fetchData() {
  //   // Fetch character tasks
  //   this.characterTaskService.getCharacterTasks().subscribe(data => {
  //     this.tasks = data;
  //   });

  //   // Fetch in-game characters (for raids)
  //   this.ingameCharacterService.getIngameCharacters().subscribe(data => {
  //     this.raids = data; // Assuming raid info is stored in this API
  //   });
  // }
}
