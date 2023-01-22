import { Component, OnInit } from '@angular/core';
import { EstimationService } from 'src/app/_services/estimation.service';

@Component({
  selector: 'app-do-estimation',
  templateUrl: './do-estimation.component.html',
  styleUrls: ['./do-estimation.component.css']
})
export class DoEstimationComponent implements OnInit {

  form: any = {
    name: null,
    categorie: null,
    brand: null,
    etat_du_produit: null,
    date: null,
    description: null
  };
  isSuccessful = false;
  isFailed = false;
  errorMessage = '';

  constructor(private estimationService: EstimationService) { }

  ngOnInit(): void {
  }
  
  onSubmit(): void {
    const {name, categorie, brand, etat_du_produit, date, description} = this.form;

    this.estimationService.postproducts(name, categorie, brand, etat_du_produit, date, description).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isFailed = false;
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isFailed = true;
      }
    });
  }
}