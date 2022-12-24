import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SlidersComponent } from './components/sliders/sliders.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { HomeComponent } from './components/home/home.component';
import { DoEstimationComponent } from './components/do-estimation/do-estimation.component';
import { PanierComponent } from './components/panier/panier.component';
import { ProfilComponent } from './components/profil/profil.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';

//creation des routes ici 
export const routes: Routes = [
  {path: 'sliders', component: SlidersComponent},
  {path: 'auth', component: AuthComponent},
  {path: 'inscription', component: InscriptionComponent},
  {path: 'home', component: HomeComponent},
  {path: 'estimation', component: DoEstimationComponent},
  {path: 'panier', component: PanierComponent},
  {path: 'profil', component: ProfilComponent},
  { path: 'user', component: BoardUserComponent },
  { path: 'doestimation', component: DoEstimationComponent},
  {path: "mod",component: BoardModeratorComponent,},
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
