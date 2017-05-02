import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http'
import {Observable} from 'rxjs/Rx'
import { BusinessEntity } from '../_models/businessEntity.model';
import { Address } from '../_models/address.model';
import { Comment } from '../_models/comment.model';
import { AuthenticationService } from '../_services/index'

//  Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class BusinessService {
    constructor(
        private _http: Http,
        private authService: AuthenticationService) { }

    private businessUserToRedirectTo:string;

    private currentBusinessStringQuery: string;

    private businessUrl = '/api/business'; // URL to web api

    getBusinesses() {
        return this._http.get(this.businessUrl)
                        .map((res:Response) => res.json());
  }

  setBusinessUserToRedirectTo(username: string){
      this.businessUserToRedirectTo = username;
  }

  getBusinessUserToRedirectTo(): string {
      return this.businessUserToRedirectTo;
  }

  getCurrentBusinessStringQuery(): string {
      return this.currentBusinessStringQuery;
  }

  setCurrentBusinessStringQuery(val:string) {
      this.currentBusinessStringQuery = val;
  }

    getBusiness(username:string) {
        var requestUrl:string = this.businessUrl + "/" + username;
        return this._http.get(requestUrl)
                        .map((res:Response) => res.json());
    }

    getBusinessComments(username:string){
        var requestUrl:string = this.businessUrl+"/"+username+"/reviews";
        return this._http.get(requestUrl)
                        .map((res:Response) => res.json());
    }

    postNewRating(userName:string, businessName:string, rating:string){
        var requestUrl: string = '/api/users/'+userName+'/'+businessName+'/ratings'+'?rate='+rating;
        var headers = new Headers();
        headers.append('userName', userName);
        headers.append('businessName', businessName);
        headers.append('rate', rating);
        var opts = new RequestOptions();
        opts.headers = headers;
        return this._http.post(requestUrl,'', opts)
                        .map((res:Response) => res.json());
    }

    // Search: Search Controller
    newSearch(query:string){
        var requestUrl: string = 'api/search?keyword='+query;
        var headers = new Headers();
        headers.append('Accept', "*/*");
        var opts = new RequestOptions();
        opts.headers = headers;
        return this._http.post(requestUrl, '', opts)
                        .map((res:Response) => res.json());
    }
}
