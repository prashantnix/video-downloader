import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DownloadVideoComponent } from './download-video.component';

describe('DownloadVideoComponent', () => {
  let component: DownloadVideoComponent;
  let fixture: ComponentFixture<DownloadVideoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DownloadVideoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DownloadVideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
