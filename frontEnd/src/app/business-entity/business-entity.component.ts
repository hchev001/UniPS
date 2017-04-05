import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';

@Component({
  selector: 'app-business-entity',
  templateUrl: './business-entity.component.html',
  styleUrls: ['./business-entity.component.css']
})
export class BusinessEntityComponent implements OnInit {

  constructor(private bsnService : BusinessService ) { }

  ngOnInit() {

      this.getBusinessInfo("chillis");

  }

  // Component Variables
  // business - Used to map the json object and interpolate its content
  // into the html
  // business: Object[];
  //
  // // used to fetch just the account information of the username paramater
  // getBusinessInfo(username:string){
  //     return this.bsnService.getBusiness(username)
  //                           .subscribe((business: Array<Object>) => this.business = business);
  //
  //   }

  business;

  // used to fetch just the account information of the username paramater
  getBusinessInfo(username:string){
    this.bsnService.getBusiness(username)
                    .subscribe(response => this.business = response.data);

    }
}
