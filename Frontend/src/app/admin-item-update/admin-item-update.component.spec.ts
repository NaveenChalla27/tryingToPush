import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminItemUpdateComponent } from './admin-item-update.component';

describe('AdminItemUpdateComponent', () => {
  let component: AdminItemUpdateComponent;
  let fixture: ComponentFixture<AdminItemUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminItemUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminItemUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
