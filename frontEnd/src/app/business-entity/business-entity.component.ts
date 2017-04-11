import { Component, OnInit } from '@angular/core';
import { BusinessService, AlertService, AuthenticationService } from '../_services/index'
import { Response } from '@angular/http';
import {RatingModule} from "ngx-rating";
import { Router } from '@angular/router';

@Component({
  selector: 'app-business-entity',
  templateUrl: './business-entity.component.html',
  styleUrls: ['./business-entity.component.css']
})
export class BusinessEntityComponent implements OnInit {

  constructor(
        private bsnService: BusinessService,
        private alertService: AlertService,
        private authService: AuthenticationService,
        private router: Router) { }

  ngOnInit() {
      var bsnUserName:string = this.bsnService.getBusinessUserToRedirectTo();
      this.getBusinessInfo(bsnUserName);
  }

  // Component Variables
  // business - Used to map the json object and interpolate its content
  // into the html
    private business: any = {};
    private address: any = {};
    private comments: any = [];

  // used to fetch just the account information of the username paramater
    getBusinessInfo(username:string){
      return this.bsnService.getBusiness(username)
            .subscribe(
                (res ) => {
                    this.business = res.data;
                    this.address = this.business.address;
                    this.comments = this.business.comments;
                },
                (err:any) => {
                    this.alertService.error(err);
                },
                () => {
                    console.log("no error and we are complete")
                }
        );

    }

    rate() {
        if (this.authService.isAuthenticated()) {
            this.router.navigate(['/leaverate']);
        } else {
            this.alertService.error("Please log in first.");
        }
    }
}
