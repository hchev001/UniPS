
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService, AuthenticationService } from '../_services/index';
import { Http, Headers, Response, RequestOptions } from '@angular/http';


@Component({
  moduleId: module.id,
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;
    data: any = {};
    authority: any = [];
    authenticated: boolean = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService,
        private http: Http) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout;
        console.log("we just logged out, my username is " + this.authenticationService.getUsername() + "and authenticated status is " + this.authenticationService.isAuthenticated().toString());

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

        login() {
        this.loading = true;
        this.authenticationService.authenticate( this.model.username, this.model.password)
        .subscribe(
          (res) => {
            this.data = res;
            this.authority = this.data.authorities;
            console.log("The authority of this user is: " + JSON.stringify(this.authority[0].authority));
            this.authenticationService.setAuthority(JSON.stringify(this.authority[0].authority));
            this.authenticationService.setUserName(this.model.username);
            this.authenticationService.setAuthenticationStatus(true);
            console.log(this.model.username + 'has been succesfully authenticated');
            this.router.navigate([this.returnUrl]);
          },
          (err: any) => {
            console.log(err);
          },
          () => {
            console.log('no error and we are complete');
          }
        );
    }


}
