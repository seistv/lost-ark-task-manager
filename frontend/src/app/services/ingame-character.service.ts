import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { IngameCharacter } from '../models/ingame-character';

@Injectable({
  providedIn: 'root'
})
export class IngameCharacterService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Get in-game characters
  getIngameCharacters(): Observable<IngameCharacter[]> {
    return this.http.get<IngameCharacter[]>(`${this.apiUrl}/ingame-characters`);
  }
  
}