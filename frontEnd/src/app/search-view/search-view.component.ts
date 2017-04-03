import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';

@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent implements OnInit {

  isDropDownMenu: boolean;
  classesObj: Object;
  businessList: Array<Object>;

  constructor(private bsnService: BusinessService) { }


  ngOnInit() {
    this.isDropDownMenu = false;
    this.toggleDropDown(event);
    this.getAllBusinesses();
  }

  getAllBusinesses() {
    this.bsnService.getBusinesses()
                    .subscribe(response => this.businessList = response.data);
  }

  toggleDropDown(event): void {
    this.isDropDownMenu = !this.isDropDownMenu;
    this.classesObj = {
      'dropdown-menu': this.isDropDownMenu
    };
  }
}
