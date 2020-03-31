import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material/material.module';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { UserHomePageComponent } from './pages/user/user-home-page/user-home-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { DownloadVideoComponent } from './components/download-video/download-video.component';
import { CreditsPageComponent } from './pages/credits-page/credits-page.component';
import { AdvancedDownloadVideoComponent } from './components/advanced-download-video/advanced-download-video.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    RegistrationPageComponent,
    UserHomePageComponent,
    LoginPageComponent,
    DownloadVideoComponent,
    CreditsPageComponent,
    AdvancedDownloadVideoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
