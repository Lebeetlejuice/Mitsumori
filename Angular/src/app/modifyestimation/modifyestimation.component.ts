import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { EstimationService } from '../_services/estimation.service';

@Component({
  selector: 'app-modifyestimation',
  templateUrl: './modifyestimation.component.html',
  styleUrls: ['./modifyestimation.component.css']
})
export class ModifyestimationComponent implements OnInit {
  data: any;
  id: any;
  form: any = {
    name: null,
    categorie: null,
    brand: null,
    etat_du_produit: null,
    date: null,
    description: null,
    price: null
  };
  isSuccessful = false;
  isFailed = false;
  errorMessage = '';

  constructor(private route: ActivatedRoute, private estimationService: EstimationService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.estimationService.getEstimation(this.id).subscribe(data=>{
      console.warn(data);
      this.data=JSON.parse(data)
    })

    this.form.setValue({
      etat_du_produit : this.data.etat_du_produit
    })

  }


  onSubmitr(): void {
    const data = {price : 12}

    this.estimationService.putEstimation(this.id, data).subscribe({
      next: datar => {
        console.log(datar);
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
