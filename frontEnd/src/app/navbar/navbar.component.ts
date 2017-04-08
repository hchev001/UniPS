import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

    constructor(private authentication: AuthenticationService) {

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

}
