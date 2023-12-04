import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { ActivatedRoute, Router} from '@angular/router';
import { EstimationService } from '../_services/estimation.service';

@Component({
  selector: 'app-modifyestimation',
  templateUrl: './modifyestimation.component.html',
  styleUrls: ['./modifyestimation.component.css']
})
export class ModifyestimationComponent implements OnInit {
  data: any = {};
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

  
  constructor(private routes: Router, private route: ActivatedRoute, private estimationService: EstimationService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.estimationService.getEstimation(this.id).subscribe(data=>{
      console.warn(data);
      this.data=JSON.parse(data)
    })

  }


  onSubmitr(): void {
    const data = {price : this.data.price, name : this.data.name, description : this.data.description,
    etat_du_produit: this.data.etat_du_produit, date: this.data.date, categorie: this.data.categorie, brand: this.data.brand}
    
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

  onDelete(): void {
    this.estimationService.deleteEstimation(this.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.routes.navigateByUrl('/mod', {skipLocationChange: true}).then(() => {
            this.routes.navigate(['ModifyestimationComponent']);
        });
        },
        error: (e) => console.error(e)
      });
  }

}
