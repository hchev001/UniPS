import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';
import { Router } from '@angular/router';
import {RatingModule} from "ngx-rating";


@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent implements OnInit {

  isDropDownMenu: boolean;
  classesObj: Object;
  businessList: Array<Object>;
  starsCount: number;
  starsCounts: number[] = [];
  querry: string;

  constructor(
        private bsnService: BusinessService,
        private router: Router)
        {
            this.querry = this.bsnService.getCurrentBusinessStringQuery();
        }


  ngOnInit() {
    this.isDropDownMenu = false;
    this.toggleDropDown(event);
    this.querry.length > 0 ? this.getQuerriedBusiness() : this.getAllBusinesses();
  }

  getAllBusinesses() {
    this.bsnService.getBusinesses()
                    .subscribe(response => this.businessList = response.data);
  }

  getQuerriedBusiness() {
      this.bsnService.newSearch(this.querry)
                        .subscribe(response => this.businessList = response.data);
  }


  toggleDropDown(event): void {
    this.isDropDownMenu = !this.isDropDownMenu;
    this.classesObj = {
      'dropdown-menu': this.isDropDownMenu
    };
  }

  public redirectTo(bsn:string) {
      console.log(bsn);
      this.bsnService.setBusinessUserToRedirectTo(bsn);
      this.router.navigate(['/businessentity']);

  }
}
