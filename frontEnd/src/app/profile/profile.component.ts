import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
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
      this.authService.getUserInfo(username).subscribe(
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
