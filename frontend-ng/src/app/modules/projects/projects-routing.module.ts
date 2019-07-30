import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../core';

import { ProjectsComponent } from './components/projects/projects.component';

const ROUTES: Routes = [
  { path: '', component: ProjectsComponent, canActivate: [ AuthGuard ] }
];

@NgModule({
  imports: [
    RouterModule.forChild(ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class ProjectsRoutingModule {}
