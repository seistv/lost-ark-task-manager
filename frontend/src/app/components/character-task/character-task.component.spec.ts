import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterTaskComponent } from './character-task.component';

describe('CharacterTaskComponent', () => {
  let component: CharacterTaskComponent;
  let fixture: ComponentFixture<CharacterTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CharacterTaskComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CharacterTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
