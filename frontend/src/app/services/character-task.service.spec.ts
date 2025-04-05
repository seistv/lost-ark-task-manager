import { TestBed } from '@angular/core/testing';

import { CharacterTaskService } from './character-task.service';

describe('CharacterTaskService', () => {
  let service: CharacterTaskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CharacterTaskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
