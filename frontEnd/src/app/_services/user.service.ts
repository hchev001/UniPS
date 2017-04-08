import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) { }



    createUser(user: any) {

        let headers: Headers = new Headers();
        headers.append('content-type', 'application/json');
        let opts: RequestOptions = new RequestOptions();
        opts.headers = headers;

        return this.http.post('/api/signupUser', user, opts)
        .map((response: Response) => response.json());
    }

    createBusiness(business: any) {
        let headers: Headers = new Headers();
        headers.append('content-type', 'application/json');
        let opts: RequestOptions = new RequestOptions();
        opts.headers = headers;

        return this.http.post('/api/signupBusiness', business, opts)
        .map((response: Response) => response.json());
    }

    // To be tested
    createAdmin(admin:any) {
        let headers: Headers = new Headers();
        headers.append('content-type', 'application/json');
        let opts: RequestOptions = new RequestOptions();
        opts.headers = headers;

        return this.http.post('/api/signupAdmin', admin, opts)
        .map((response: Response) => response.json());

    }


}
