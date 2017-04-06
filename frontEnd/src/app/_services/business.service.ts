import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http'
import {Observable} from 'rxjs/Rx'
import { BusinessEntity } from '../_models/businessEntity.model';
import { Address } from '../_models/address.model';
import { Comment } from '../_models/comment.model';

//  Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class BusinessService {


  private businessUrl = '/api/business'; // URL to web api

  constructor(private _http: Http) { }
  getBusinesses() {
    return this._http.get(this.businessUrl)
                      .map((res:Response) => res.json())
                      .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
  }

}
