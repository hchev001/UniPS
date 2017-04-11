import { Component, OnInit } from '@angular/core';
import { BusinessService, AlertService, AuthenticationService} from '../_services/index'
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import {RatingModule} from "ngx-rating";

@Component({
    selector: 'app-leave-rate',
    templateUrl: './leave-rate.component.html',
    styleUrls: ['./leave-rate.component.css']
})
export class LeaveRateComponent implements OnInit {

    constructor(
        private bsnService: BusinessService,
        private alertService: AlertService,
        private authService: AuthenticationService,
        private router: Router,

    ) {

    }

    ngOnInit() {
        var currentBusiness = this.bsnService.getBusinessUserToRedirectTo();
        console.log("The business we are going to be redirected to is:" +currentBusiness);
        this.getBusinessInfo(currentBusiness);
        this.currentUser = this.authService.getUsername();
    }

    private business: any = {};
    private address: any = {};
    starsCount: number;

    private rating: string;
    private currentUser: string;
    private currentBusiness: string;

    private ratingResponse: any = {};
    private ratingResponseData: any = {};


    // used to fetch just the account information of the username paramater
    getBusinessInfo(username:string){
        return this.bsnService.getBusiness(username)
            .subscribe(
                (res ) => {
                    this.business = res.data;
                    this.currentBusiness = res.data.username;
                    this.address = this.business.address;
                },
                (err:any) => {
                    this.alertService.error(err);
                },
                () => {
                    console.log("no error and we are complete")
                }
        );

    }

    submitReview(){
        console.log(this.starsCount);
        if (this.authService.isAuthenticated())
        {
            this.rating = this.parseStarCount(this.starsCount);
            this.bsnService.postNewRating(this.currentUser, this.currentBusiness, this.rating)
                            .subscribe(
                                (res) => {
                                    this.ratingResponse = res;
                                    this.ratingResponseData = res.data;
                                },
                                (err:any) => {
                                    console.log(err);
                                },
                                () => {
                                    console.log("no errors posting new rating");
                                }
                            );
            this.alertService.success('Your rating has been succesfully added', true);
            this.router.navigate(['/businessentity']);
        } else {
            console.log("user is not logged in");
        }
    }

    private parseStarCount(count: number):string {
        var value: string = 'BAD';

        if (count == 0 || count == 1)
            value = "BAD";
        if (count == 2)
            value = "REGULAR";
        if (count == 3)
            value = "AVERAGE";
        if (count == 4)
            value = "GOOD";
        if (count == 5)
            value = "EXCELLENT"

        return value;
    }
}
