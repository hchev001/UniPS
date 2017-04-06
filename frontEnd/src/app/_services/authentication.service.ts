﻿//The authentication service is used to login and logout of the application,
//to login it posts the users credentials to the api and checks the response for a token,
//if there is one it means authentication was successful so the user details including the
//token are added to local storage.
import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {
        return this.http.post('/api/authenticate', JSON.stringify({ username: username, password: password }))
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

    login2() {
        var headers = {authorization : "Basic" + btoa("kathy:null")};
        return this.http.get('/api/userInfo', headers )
                        .map(this.extractData);
    }

    login3() {
        var headers = {authorization : "Basic" + btoa("kathy:k123")};
        return this.http.get('/api/userInfo', headers )
                        .map(response => response.json());
    }

    private extractData(res: Response) {
        let body;
        if(res.text()) {
            body = res.json();
        }

        return body || {};
    }
}
