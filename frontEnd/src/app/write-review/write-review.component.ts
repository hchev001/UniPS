import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Response } from '@angular/http';
import { BusinessService, AlertService, AuthenticationService} from '../_services/index'

@Component({
    selector: 'app-write-review',
    templateUrl: './write-review.component.html',
    styleUrls: ['./write-review.component.css']
})
export class WriteReviewComponent implements OnInit {

    constructor(
        private bsnService: BusinessService,
        private alertService: AlertService,
        private authService: AuthenticationService,
        private router: Router,
    ) { }

    ngOnInit() {
        var currentBusiness = this.bsnService.getBusinessUserToRedirectTo();
        console.log("The business we are going to be redirected to is:" +currentBusiness);
        this.getBusinessInfo(currentBusiness);
        this.currentUser = this.authService.getUsername();
    }

    private business: any = {};
    private address: any = {};
    private currentBusiness: string;
    private textValue = "Write your review here";
    private log: string = '';
        private currentUser: string;


    private submitReview(value: string): void {
        this.newReview(value);
        this.router.navigate(['/businessentity']);

    }
    private newReview(value: string): void {
        if (this.authService.isAuthenticated())
        {
            this.bsnService.postNewReview(this.currentUser, this.currentBusiness, this.textValue)
                            .subscribe(
                                (res) => {
                                    console.log("no response body");
                                },
                                (err:any) => {
                                    console.log(err);
                                },
                                () => {
                                    console.log("no errors posting new review");
                                }
                            );
            this.alertService.success('Your review has been succesfully added', true);
            this.router.navigate(['/businessentity']);
        } else {
            console.log("user is not logged in");
        }
    }


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
}
