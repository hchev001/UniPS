import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services/index'
import { Response } from '@angular/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(
      private authService: AuthenticationService
  ) { }

  ngOnInit() {
  }

  
}
