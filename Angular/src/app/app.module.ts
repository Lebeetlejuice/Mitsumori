import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SlidersComponent } from './components/sliders/sliders.component';
import { AppRoutingModule } from './app-routing.module';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { AuthComponent } from './components/auth/auth.component';
import { HomeComponent } from './components/home/home.component';
import { DoEstimationComponent } from './components/do-estimation/do-estimation.component';
import { PanierComponent } from './components/panier/panier.component';
import { ProfilComponent } from './components/profil/profil.component';
import { BoardAdminComponent } from './components/list-user-admin/board-admin.component';
import { BoardModeratorComponent } from './components/list-estimation-moderator/board-moderator.component';
import { BoardUserComponent } from './components/accueil-user/board-user.component';
import { httpInterceptorProviders} from './_helpers/auth.interceptor';
import { ModifyestimationComponent } from './modifyestimation/modifyestimation.component';

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
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    ModifyestimationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
