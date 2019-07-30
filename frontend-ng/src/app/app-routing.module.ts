import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './modules/core';

import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const ROUTES: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule),
  },
  {
    path: 'home',
    loadChildren: () => import('./modules/home/home.module').then(m => m.HomeModule),
    canActivate: [ AuthGuard ]
  },
  {
    path: 'projects',
    loadChildren: () => import('./modules/projects/projects.module').then(m => m.ProjectsModule),
    canActivateChild: [ AuthGuard ]
  },
  {
    path: 'board',
    loadChildren: () => import('./modules/board/board.module').then(m => m.BoardModule),
    canActivateChild: [ AuthGuard ]
  },
  {
    path: 'admin',
    loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule),
    canActivateChild: [ AuthGuard ]
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(ROUTES, {
      enableTracing: false,  // TODO: move to configuration
    })],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
