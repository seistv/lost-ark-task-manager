import { TestBed } from '@angular/core/testing';

import { IngameCharacterService } from './ingame-character.service';

describe('IngameCharacterService', () => {
  let service: IngameCharacterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngameCharacterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
