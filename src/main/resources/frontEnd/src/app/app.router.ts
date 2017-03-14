import {ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthGuard } from './_guards/index';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';

export const router: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: 'home', component: HomeComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);