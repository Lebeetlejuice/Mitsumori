import { Component, OnInit } from '@angular/core';
import { Images } from '../service/estimations';

export interface Image {
  url: string;
}

@Component({
  selector: 'app-sliders',
  templateUrl: './sliders.component.html',
  styleUrls: ['./sliders.component.css']
})

export class SlidersComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  Image = Images;

  
}
