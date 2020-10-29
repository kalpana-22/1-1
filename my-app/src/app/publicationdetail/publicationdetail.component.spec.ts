import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicationdetailComponent } from './publicationdetail.component';

describe('PublicationdetailComponent', () => {
  let component: PublicationdetailComponent;
  let fixture: ComponentFixture<PublicationdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicationdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicationdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
