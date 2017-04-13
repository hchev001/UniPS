import { Component, OnInit } from '@angular/core';
import { BusinessService, AlertService, AuthenticationService } from '../_services/index'

@Component({
  selector: 'app-business-profile',
  templateUrl: './business-profile.component.html',
  styleUrls: ['./business-profile.component.css']
})
export class BusinessProfileComponent implements OnInit {

  constructor(
            private bsnService: BusinessService,
            private alertService: AlertService,
            private authService: AuthenticationService) { }


  ngOnInit() {
      this.populateBusinessInfo();
      this.populateBusinessComments();
  }



    // Component Variables
    // business - Used to map the json object and interpolate its content
    // into the html
      private business: any = {};
      private address: any = {};
      private comments: any = [];

    // used to fetch just the account information of the username paramater
      populateBusinessInfo(){
        var username = this.authService.getUsername();
        return this.bsnService.getBusiness(username)
              .subscribe(
                  (res ) => {
                      this.business = res.data;
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

      populateBusinessComments(){
          var username = this.authService.getUsername();
          return this.bsnService.getBusinessComments(username)
            .subscribe(
                (res) => {
                    this.comments = res.data;
                }
            )
      }
}
