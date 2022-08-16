import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SlidersComponent } from './sliders/sliders.component';
import { RouterModule, Routes } from '@angular/router';

//creation des routes ici 
const routes: Routes = [
  {path: 'sliders', component: SlidersComponent}
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
