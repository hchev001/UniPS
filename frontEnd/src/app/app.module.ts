import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { routes } from './app.router';
import { AppComponent } from './app.component';

import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/index';
import { SearchFieldComponent } from './search-field/search-field.component';

import { AlertModule } from 'ng2-bootstrap';
import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService } from './_services/index';

// used to create fake backend
/*
import { fakeBackendProvider } from './_helpers/fake-backend';
*/
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    HomeComponent,
    SearchFieldComponent,
    AlertComponent,
  ],
  imports: [
    BrowserModule,
    AlertModule.forRoot(),
    FormsModule,
    HttpModule,
    routes,
    
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,

    // providers used to create fake backend
    /*
    fakeBackendProvider,
    */
    MockBackend,
    BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
