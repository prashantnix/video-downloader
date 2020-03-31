import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvancedDownloadVideoComponent } from './advanced-download-video.component';

describe('AdvancedDownloadVideoComponent', () => {
  let component: AdvancedDownloadVideoComponent;
  let fixture: ComponentFixture<AdvancedDownloadVideoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvancedDownloadVideoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvancedDownloadVideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
