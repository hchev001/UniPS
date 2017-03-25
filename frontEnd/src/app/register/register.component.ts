

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

  isSecurityQuestion1DropDown: boolean;
  isSecurityQuestion2DropDown: boolean;
  classesObj1: Object;

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
      this.isSecurityQuestion1DropDown = false;
      this.isSecurityQuestion2DropDown = false;
      this.toggleDropDown1(event);
      this.toggleDropDown2(event);
  }

  toggleDropDown1(event): void {
      this.isSecurityQuestion1DropDown = !this.isSecurityQuestion1DropDown;
      this.classesObj1 = {
          'dropdown-menu': this.isSecurityQuestion1DropDown
      };
  }

  toggleDropDown2(event): void {
      this.isSecurityQuestion2DropDown = !this.isSecurityQuestion2DropDown;
      this.classesObj1 = {
          'dropdown-menu': this.isSecurityQuestion2DropDown;
      };
  }

}
