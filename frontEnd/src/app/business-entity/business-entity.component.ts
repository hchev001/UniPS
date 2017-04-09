import { Component, OnInit } from '@angular/core';
import { BusinessService, AlertService } from '../_services/index'
import { Response } from '@angular/http';

@Component({
  selector: 'app-business-entity',
  templateUrl: './business-entity.component.html',
  styleUrls: ['./business-entity.component.css']
})
export class BusinessEntityComponent implements OnInit {

  constructor(
        private bsnService: BusinessService,
        private alertService: AlertService) { }

  ngOnInit() {
      this.getBusinessInfo("chillis");
  }

  // Component Variables
  // business - Used to map the json object and interpolate its content
  // into the html
    private business: any = {};
    private address: any = {};

  // used to fetch just the account information of the username paramater
  getBusinessInfo(username:string){
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
}
