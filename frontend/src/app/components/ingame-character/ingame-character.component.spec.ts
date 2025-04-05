import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngameCharacterComponent } from './ingame-character.component';

describe('IngameCharacterComponent', () => {
  let component: IngameCharacterComponent;
  let fixture: ComponentFixture<IngameCharacterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IngameCharacterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IngameCharacterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
