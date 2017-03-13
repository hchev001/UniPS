import {ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

export const router: Routes = [
    { path: '', redirectTo: 'about', pathMatch: 'full'},
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);