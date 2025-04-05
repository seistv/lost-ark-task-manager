import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { CharacterTask } from '../models/character-task';

@Injectable({
  providedIn: 'root'
})
export class CharacterTaskService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Get character tasks
  getCharacterTasks(): Observable<CharacterTask[]> {
    return this.http.get<CharacterTask[]>(`${this.apiUrl}/character-tasks`);
  }
  
}