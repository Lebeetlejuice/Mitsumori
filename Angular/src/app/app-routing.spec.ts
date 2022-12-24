import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

import { routes } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { SlidersComponent } from './sliders/sliders.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { AuthComponent } from './auth/auth.component';
import { ProfilComponent } from './profil/profil.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';

describe('AppComponent', () => {
  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

    it('should contain route for /home', () => {
        const expectedRoute = {path: 'home', component: HomeComponent};
        expect(routes).toContain(expectedRoute);
    });
    it('should contain route for /sliders', () => {
        const expectedRoute = {path: 'sliders', component: SlidersComponent};
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /inscription', () => {
        const expectedRoute = {path: 'inscription', component: InscriptionComponent};
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /auth', () => {
        const expectedRoute = {path: 'auth', component: AuthComponent};
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /profil', () => {
        const expectedRoute = {path: 'profil', component: ProfilComponent};
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /user', () => {
        const expectedRoute = { path: 'user', component: BoardUserComponent };
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /mod', () => {
        const expectedRoute = { path: 'mod', component: BoardModeratorComponent };
        expect(routes).toContain(expectedRoute);
    });

    it('should contain route for /admin', () => {
        const expectedRoute = { path: 'admin', component: BoardAdminComponent };
        expect(routes).toContain(expectedRoute);
    });
});