// The Authentication serivce is used to GET the user's login information credentials based
﻿// on their username and password
import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }


    authenticate(username:string, password:string) {

        var encodedCredentials: string = 'Basic ' + btoa(username+':'+password);

        let headers: Headers = new Headers

        headers.append('X-Requested-With', 'XMLHttpRequest');
        headers.append('authorization', encodedCredentials);

        let opts: RequestOptions = new RequestOptions
        opts.headers = headers;

        return this.http.get('/api/userInfo', opts )
                        .map(response => response.json());
    }
}
