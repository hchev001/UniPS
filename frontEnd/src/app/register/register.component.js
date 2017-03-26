"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
/*The register component has a single register() method that creates
 a new user with the user service when the register form is submitted.*/
var core_1 = require("@angular/core");
var RegisterComponent = (function () {
    function RegisterComponent(router, userService, alertService) {
        this.router = router;
        this.userService = userService;
        this.alertService = alertService;
        this.model = {};
        this.loading = false;
    }
    RegisterComponent.prototype.register = function () {
        var _this = this;
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(function (data) {
            _this.alertService.success('Registration successful', true);
            _this.router.navigate(['/login']);
        }, function (error) {
            _this.alertService.error(error);
            _this.loading = false;
        });
    };
    RegisterComponent.prototype.ngOnInit = function () {
        this.isSecurityQuestion1DropDown = false;
        this.isSecurityQuestion2DropDown = false;
        this.toggleDropDown1(event);
        this.toggleDropDown2(event);
    };
    RegisterComponent.prototype.toggleDropDown1 = function (event) {
        this.isSecurityQuestion1DropDown = !this.isSecurityQuestion1DropDown;
        this.classesObj1 = {
            'dropdown-menu': this.isSecurityQuestion1DropDown
        };
    };
    RegisterComponent.prototype.toggleDropDown2 = function (event) {
        this.isSecurityQuestion2DropDown = !this.isSecurityQuestion2DropDown;
        this.classesObj1 = {
            'dropdown-menu': this.isSecurityQuestion2DropDown
        };
    };
    return RegisterComponent;
}());
RegisterComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        selector: 'app-register',
        templateUrl: './register.component.html',
        styleUrls: ['./register.component.css']
    })
], RegisterComponent);
exports.RegisterComponent = RegisterComponent;
