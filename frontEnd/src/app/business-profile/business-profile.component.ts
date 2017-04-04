import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index'

@Component({
  selector: 'app-business-profile',
  templateUrl: './business-profile.component.html',
  styleUrls: ['./business-profile.component.css']
})
export class BusinessProfileComponent implements OnInit {

  constructor(private bsnService: BusinessService) { }


  ngOnInit() {

  }

  business = {};
  getBusinessInfo(username:string){
      return this.bsnService.getBusiness(username)
                            .subscribe(response => this.business = response.data);
  }
}
