// The Authentication serivce is used to GET the user's login information credentials based
﻿// on their username and password
import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
  // Instance variables
  private authenticated:boolean = false;
  private authority:string = '';
  private username: string = '';
  private accountNonLocked: boolean;
  private accountNonExpired: boolean;
  private credentialsNonExpired:boolean;
  private enabled:boolean;

  // Getters
  isAuthenticated(): boolean {
    return this.authenticated;
  }

  getAuthority(): string {
    return this.authority;
  }

  getUsername(): string {
    return this.username;
  }

  isAccountNonLocked():boolean {
    return this.accountNonLocked;
  }

  isAccountNonExpired(): boolean {
    return this.accountNonExpired;
  }

  isCredentialsNonExpired(): boolean {
    return this.credentialsNonExpired;
  }
  isEnbaled(): boolean {
    return this.enabled;
  }


  // Setters

  setAuthenticationStatus(status:boolean):void{
    this.authenticated = status;
  }

  setAuthority( authority: string): void {
    this.authority = authority;
  }

  setUserName( name: string): void {
    this.username = name;
  }

  setLockAccountStatus(status: string): boolean {
    if (status === 'true')
      this.accountNonLocked = true;
    else
      this.accountNonLocked = false;
    return this.accountNonLocked;
  }


  setExpirationForAccount(status: string): boolean {
    if (status === "true")
        this.accountNonExpired = true;
    else
        this.accountNonExpired = false;
    return this.accountNonExpired
  }

  setExpirationForCredentialStatus( status: string) : boolean {
    if (status === 'true')
        this.credentialsNonExpired = true;
    else
        this.credentialsNonExpired = false;

    return this.credentialsNonExpired;
  }

  setEnableStatus( status: string): boolean {
    if (status === 'true')
        this.enabled = true;
    else
        this.enabled = false;

    return this.enabled;
  }

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

    public getUserInfo(username:string){
    let headers: Headers = new Headers();

    // headers.append('user', username);
    // let opts:RequestOptions = new RequestOptions();
    // opts.headers = headers;
    var uri = '/api/users/' + username;
    return this.http.get(uri)
                    .map(response => response.json());

    }

    logout(): void {
        this.authenticated = false;
        this.username = '';
    }

    public getAdminInfo(username:string){
    let headers: Headers = new Headers();

    // headers.append('user', username);
    // let opts:RequestOptions = new RequestOptions();
    // opts.headers = headers;
    var uri = '/api/admin/' + username;
    return this.http.get(uri)
                    .map(response => response.json());

    }
}
