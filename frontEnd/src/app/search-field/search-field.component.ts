import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';
import { BusinessEntity} from '../_models/businessEntity.model';

@Component({
  selector: 'app-search-field',
  templateUrl: './search-field.component.html',
  styleUrls: ['./search-field.component.css']
})
export class SearchFieldComponent implements OnInit {

  constructor(private bizService: BusinessService) {}

businessList: BusinessEntity[] = [];
bizList = {}

getAllBiz() {
  this.bizService.getBusinesses()
                  .subscribe(data => this.businessList = data);
  console.log(this.bizList);

  // this.bizService.getBusinessesNew()
  //                 .subscribe(data => this.biz = data);
  // console.log(this.businessList);
  // console.log(this.biz);
}
  ngOnInit() {
  }

}
