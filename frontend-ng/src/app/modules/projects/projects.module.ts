import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';

import { SharedModule } from '../shared';

import { ProjectsComponent } from './components/projects/projects.component';
import { ProjectsListComponent } from './components/projects-list/projects-list.component';

import { ProjectsRoutingModule } from './projects-routing.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,

    MatProgressSpinnerModule,
    MatTableModule,
    MatToolbarModule,

    ProjectsRoutingModule,
  ],
  exports: [ RouterModule ],
  declarations: [
    ProjectsComponent,
    ProjectsListComponent,
  ],
  providers: []
})
export class ProjectsModule { }
