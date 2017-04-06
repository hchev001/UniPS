/*The login component uses the authentication service to login and logout of the application.
//It automatically logs the user out when it initializes (ngOnInit) so the login page can
also be used to logout.*/
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
    model2: any = {};
    model3
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
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

        this.alfredoLogin();
        if (this.authenticated)
            console.log("we've beeb authenticated")
        else
            console.log("we weren't authenticated")
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }

    // alfredoLogin() {
    //     // this.loading = true;
    //     this.authenticationService.login3('kathy', 'k123')
    //         .subscribe(data => {
    //             if(data.name) {
    //                 this.authenticated = true;
    //                 this.data = data;
    //             } else {
    //                 this.authenticated = false;
    //                 this.data = data;
    //             }
    //         });
    // }
    alfredoLogin() {
        // this.loading = true;
        var encodedCredentials: string = btoa('Basic '+'kathy'+':'+'k123');

        let headers: Headers = new Headers();
        headers.append('X-XSRF-TOKEN', 'ff56ba5e-eb39-4999f-bcb8-e5a6b0dac267');
        headers.append('X-Requested-With', 'XMLHttpRequest');
        headers.append('authorization', encodedCredentials);

        let opts: RequestOptions = new RequestOptions
        opts.headers = headers;

        this.http.get('/api/userInfo', opts)
            .subscribe((res:Response) => {
              this.data = res.json();
              this.authenticated = true;
              console.log("Authenticated woot woot");
            })
    }


}
