import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../_services/index';
import { BusinessEntity} from '../_models/businessEntity.model';

@Component({
  selector: 'app-search-field',
  templateUrl: './search-field.component.html',
  styleUrls: ['./search-field.component.css'],
})
export class SearchFieldComponent implements OnInit {

  constructor(private bizService: BusinessService) {
    this.getAllBiz();
  }

  businessList: BusinessEntity[];

  bizList: Array<Object>;

  getAllBiz() {
  this.bizService.getBusinesses()
                  .subscribe(response => this.bizList = response.data);
  console.log(this.bizList);
  }
  ngOnInit() {
  }

  // add special functions for when we also instantiate the array of comments, ratings,
  // and address
  static toInstance<T>(obj: T, json: string) : T {
    var jsonObj = JSON.parse(json);

    if (typeof["fromJSON"] === "function") {
      obj["fromJSON"](jsonObj);
    }
    else {
      for (var propName in jsonObj) {
        if (jsonObj[propName] == 'comments') {

        }
        obj[propName] = jsonObj[propName] == undefined ? undefined : jsonObj[propName];
      }
    }
    return obj;
  }
}
