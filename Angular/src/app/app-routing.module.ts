import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SlidersComponent } from './sliders/sliders.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { HomeComponent } from './home/home.component';
import { DoEstimationComponent } from './do-estimation/do-estimation.component';
import { PanierComponent } from './panier/panier.component';
import { ProfilComponent } from './profil/profil.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';

//creation des routes ici 
const routes: Routes = [
  {path: 'sliders', component: SlidersComponent},
  {path: 'auth', component: AuthComponent},
  {path: 'inscription', component: InscriptionComponent},
  {path: 'home', component: HomeComponent},
  {path: 'estimation', component: DoEstimationComponent},
  {path: 'panier', component: PanierComponent},
  {path: 'profil', component: ProfilComponent},
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
