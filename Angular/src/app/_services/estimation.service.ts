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

  getEstimations(): Observable<any> {
    return this.http.get(PRODUCT_API + 'mod', { responseType: 'text' });
  }

  getEstimation(id: any): Observable<any> {
    return this.http.get(PRODUCT_API + 'mod/' + id, { responseType: 'text' });
  }

  putEstimation(id: any, data: any): Observable<any> {
    return this.http.put(PRODUCT_API +'put/'+id, data);
  }

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
