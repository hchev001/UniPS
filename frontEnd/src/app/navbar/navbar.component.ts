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

    loggedIn(): boolean {

        return this.authentication.isAuthenticated();
    }

    logout(event): void {
        this.authentication.logout();
    }

}
