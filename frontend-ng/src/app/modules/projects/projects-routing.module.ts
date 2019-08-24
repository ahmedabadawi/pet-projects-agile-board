import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../core';

import { ProjectsComponent } from './components/projects/projects.component';
import { ProjectsListComponent } from './components/projects-list/projects-list.component';

const ROUTES: Routes = [
  {
    path: '',
    component: ProjectsComponent,
    canActivate: [ AuthGuard ],
    children: [
      { path: 'projects-list', component: ProjectsListComponent },
      { path: '', redirectTo: 'projects-list' },
    ],
  }
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
