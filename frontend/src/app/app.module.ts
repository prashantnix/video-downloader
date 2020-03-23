import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FlexLayoutModule } from '@angular/flex-layout';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialComponentsModule } from './modules/material-components.module';
import { CovalentComponentsModule } from './modules/covalent-components.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,

    MaterialComponentsModule,
    CovalentComponentsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
