import { Component, OnInit } from '@angular/core';
import { Images } from '../service/estimations';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  Image = Images;

}
