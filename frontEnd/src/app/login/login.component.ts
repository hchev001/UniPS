
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
    data: Object;
    authenticated: boolean = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService,
        private http: Http) { }

    ngOnInit() {
        // reset login status


        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

        login() {
        this.loading = true;
        this.authenticationService.authenticate( this.model.username, this.model.password)
        .subscribe(
          (res:Response) => {
            this.data = res;
            this.authenticated = true;
            console.log("Authenticated woot woot");
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
