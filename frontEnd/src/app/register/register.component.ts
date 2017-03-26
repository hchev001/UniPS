

/*The register component has a single register() method that creates
 a new user with the user service when the register form is submitted.*/
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, UserService } from '../_services/index';

@Component({
  moduleId: module.id,
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: any = {};
  loading = false;

  businessAcountFields: boolean;
  userAccountFields: boolean;



  constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }


  register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }

  ngOnInit() {
    this.businessAcountFields = false;
    console.log(this.businessAcountFields);
    this.userAccountFields = false;
    console.log(this.userAccountFields);

  }

  userFieldToggle () : boolean {
    this.userAccountFields = !this.userAccountFields;
    this.businessAcountFields = false;
    console.log(this.userAccountFields);
    console.log(this.businessAcountFields);
    return this.userAccountFields;
  }

  businessFieldToggle () : boolean {
    this.businessAcountFields = !this.businessAcountFields;
    this.businessAcountFields = true;
    console.log(this.businessAcountFields);
    console.log(this.userAccountFields);
    return this.businessAcountFields;
  }

}
