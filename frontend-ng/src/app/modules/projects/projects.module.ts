import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';

import { ProjectsComponent } from './components/projects/projects.component';

import { ProjectsRoutingModule } from './projects-routing.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,

    ProjectsRoutingModule,
  ],
  exports: [ RouterModule ],
  declarations: [
    ProjectsComponent
  ],
  providers: []
})
export class ProjectsModule { }
