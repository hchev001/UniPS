import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
    // isntance Variables
    model: any = {};
  constructor(
      private authService: AuthenticationService
  ) { }

  ngOnInit() {
      this.populateModel();
  }

  populateModel() {
      var username = this.authService.getUsername();
      this.authService.getAdminInfo(username).subscribe(
        (res) => {
            this.model = res.data;
        },
        (err:any) => {
            console.log(err);
        },
        () => {
            console.log("no error fetching user info");
        }
    );

  }
}
