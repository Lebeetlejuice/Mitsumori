import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-do-estimation',
  templateUrl: './do-estimation.component.html',
  styleUrls: ['./do-estimation.component.css']
})
export class DoEstimationComponent implements OnInit {

  form: any = {
    brand: null,
    name: null,
    date: null,
    description: null,
    etat_du_produit: null
  };
  constructor() { }

  ngOnInit(): void {
  }

}