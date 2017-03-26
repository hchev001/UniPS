import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent implements OnInit {

  isDropDownMenu: boolean;
  classesObj: Object;

  constructor() { }

  ngOnInit() {
    this.isDropDownMenu = false;
    this.toggleDropDown(event);
  }

  toggleDropDown(event): void {
    this.isDropDownMenu = !this.isDropDownMenu;
    this.classesObj = {
      'dropdown-menu': this.isDropDownMenu
    };
  }
}
