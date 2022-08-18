import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SlidersComponent } from './sliders/sliders.component';
import { AppRoutingModule } from './app-routing.module';
import { InscriptionComponent } from './inscription/inscription.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { DoEstimationComponent } from './do-estimation/do-estimation.component';
import { PanierComponent } from './panier/panier.component';
import { ProfilComponent } from './profil/profil.component';

@NgModule({
  declarations: [
    AppComponent,
    SlidersComponent,
    InscriptionComponent,
    AuthComponent,
    HomeComponent,
    DoEstimationComponent,
    PanierComponent,
    ProfilComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
