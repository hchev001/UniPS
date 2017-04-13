import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services';
import { Router } from '@angular/router';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

    constructor(
        private authentication: AuthenticationService,
        private router: Router) {

    }

    ngOnInit() {

    }

    // Retrieves the status of the current user browsing the website
    // Returns true if the user has previously logged in
    // else false
    loggedIn(): boolean {

        return this.authentication.isAuthenticated();
    }

    // calls authentication service logout function to clear credentials
    logout(event): void {
        this.authentication.logout();
    }

    viewProfile() {
        if (this.authentication.getAuthority() == '"ROLE_ADMIN"'){
            console.log("visit admin profile");
            this.router.navigate(['/adminprofile'])
        }
        if (this.authentication.getAuthority() == '"ROLE_USER"'){
            console.log("visit user profile");
            this.router.navigate(['/profile'])
        }
        if (this.authentication.getAuthority() == '"ROLE_BUSINESS"'){
            console.log("visit business profile");
            this.router.navigate(['/businessprofile'])
        }
    }
}
