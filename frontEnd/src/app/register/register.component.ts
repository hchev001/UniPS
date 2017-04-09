

/*The register component has a single register() method that creates
 a new user with the user service when the register form is submitted.*/
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
<<<<<<< 28a304dbb46558aaf9d345569cd43f71c5a190de
import { Response } from '@angular/http';
=======

>>>>>>> removed tutorial content from register.html form and left bare minimum
import { AlertService, UserService } from '../_services/index';

@Component({
  moduleId: module.id,
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: any = {};
  private responseModel: any = {};
  loading = false;

  private businessAcountFields: boolean;
  private userAccountFields: boolean;



  constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }


  // register() {
  //       this.loading = true;
  //       this.userService.create(this.model)
  //           .subscribe(
  //               data => {
  //                   this.alertService.success('Registration successful', true);
  //                   this.router.navigate(['/login']);
  //               },
  //               error => {
  //                   this.alertService.error(error);
  //                   this.loading = false;
  //               });
  //   }

<<<<<<< 28a304dbb46558aaf9d345569cd43f71c5a190de
    register(value: any) {
        if(this.businessAcountFields)
            this.userService.createBusiness(value)
            .subscribe(
                (res:Response) => {
                    this.responseModel = res;
                    if (this.responseModel.status === "success")
                        console.log("Succesful creation of business");
                },
                (err: any) => {
                  console.log(err);
                },
                () => {
                  console.log('no error and we are complete');
                }
            );
        else
            this.userService.createUser(value)
            .subscribe(
                (res:Response) => {
                    this.responseModel = res;
                    if (this.responseModel.status === 'success')
                        console.log("Succesful creation of business");
                },
                (err: any) => {
                    console.log(err);
                },
                () => {
                    console.log('no error and we are complete');
                }
            );
    }

    onSubmit(value: any) {
        console.log(value.answer1);

=======
    register() {
        this.loading = true;
        console.log(this.model.username);
        console.log(this.model.firstName);
        console.log(this.model.lastName);
        console.log(this.model.password);
        console.log(this.model.email);
    }

    onSubmit(value: any) {
        console.log(value);
>>>>>>> removed tutorial content from register.html form and left bare minimum
    }

  ngOnInit() {
    this.businessAcountFields = false;
    this.userAccountFields = false;

  }

  userFieldToggle () : boolean {
    this.userAccountFields = !this.userAccountFields;
    this.businessAcountFields = false;
    return this.userAccountFields;
  }

  businessFieldToggle () : boolean {
    this.businessAcountFields = !this.businessAcountFields;
    this.userAccountFields = false;
    return this.businessAcountFields;
  }

  isUserFieldActive () : boolean {
    return this.userAccountFields;
  }

  isBusinessFieldActive () : boolean {
    return this.businessAcountFields;
  }

  defaultFieldsViawable () : boolean {
    return this.userAccountFields || this.businessAcountFields;
  }

}
