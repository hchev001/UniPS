import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';
import { BusinessEntity} from '../_models/businessEntity.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-field',
  templateUrl: './search-field.component.html',
  styleUrls: ['./search-field.component.css'],
})
export class SearchFieldComponent implements OnInit {

  constructor(  private bizService: BusinessService,
                private router: Router) {
  }


  ngOnInit() {
  }

  search(userQuery: string) {

      // checks if user input is not zero, null, or undefined
      if(!this.isEmpty(userQuery)){
          this.bizService.setCurrentBusinessStringQuery(userQuery);
      } else {
          this.bizService.setCurrentBusinessStringQuery("");
      }
      this.router.navigate(['/search']);
  }

  isEmpty(val:string):boolean {
      return (val === undefined || val == null || val.length < 0);
  }
}
