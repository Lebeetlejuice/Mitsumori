import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const PRODUCT_API = 'http://localhost:8080/api/products/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EstimationService {

  constructor(private http: HttpClient) { }

  postproducts(name: string, categorie: string, brand: string, etat_du_produit: string, date: Date, description: string): Observable<any> {
    return this.http.post(PRODUCT_API + 'post', {
      name,
      brand,
      categorie,
      etat_du_produit,
      date,
      description
    }, httpOptions);
  }
}
