import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http'
import {Observable} from 'rxjs/Rx'
import { BusinessEntity } from '../_models/businessEntity.model';

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

  getBusinessesNew(): Observable<BusinessEntity> {
    let listOfBiz = this._http
      .get(this.businessUrl)
      .map(this.mapBusinesses)
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
      return listOfBiz;
  }

  // Used to map each json entry to a bussiness entity model
  mapBusinesses( response:Response): BusinessEntity[]{
    return response.json().results.map(this.toBusiness);
  }

  mapBusiness(response:Response): BusinessEntity{
    return this.toBusiness(response.json());
  }


  toBusiness(r:any): BusinessEntity{
    let biz = <BusinessEntity>({
      id: r.id,
      createdDate: r.createdDate,
      username: r.username,
      password: r.password,
      email: r.email,
      question1: r.question1,
      question2: r.question2,
      pictureFeatured: r.pictureFeatured,
      pictures: r.pictures,
      description: r.description,
      status: r.status,
      role: r.role,
      token: r.token,
      name: r.name,
      phone: r.phone,
      phoneBusiness: r.phoneBusiness,
      hours: r.hours,
      rateAverage: r.rateAverage,
      comments: r.comments,
      ratings: r.ratings,
      address: r.address,
      category: r.category
    });
    console.log('Parsed business:', biz);
    return biz;
  }
}
