import {ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthGuard } from './_guards/index';

//import { HomeComponent } from './home/home.component';
import { HomeComponent } from './home/index';
import { ProfileComponent } from './profile/profile.component';
import { SearchViewComponent } from './search-view/search-view.component'
import { BusinessEntityComponent } from './business-entity/business-entity.component'
import { BusinessProfileComponent } from './business-profile/business-profile.component'
import { AdminProfileComponent }  from './admin-profile/admin-profile.component'
import { EditProfileViewComponent } from './edit-profile-view/edit-profile-view.component'
import { LeaveRateComponent } from './leave-rate/leave-rate.component';
import { WriteReviewComponent } from './write-review/write-review.component';
import { DummyComponent } from './dummy/dummy.component';

export const router: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: 'home', component: HomeComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'search', component: SearchViewComponent },
    { path: 'businessentity', component: BusinessEntityComponent },
    { path: 'businessprofile', component: BusinessProfileComponent },
    { path: 'adminprofile', component: AdminProfileComponent },
    { path: 'editprofile', component: EditProfileViewComponent },
    { path: 'leaverate', component: LeaveRateComponent },
    { path: 'writereview', component: WriteReviewComponent },
    { path: 'blank', component: DummyComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
