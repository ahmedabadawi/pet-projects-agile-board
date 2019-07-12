import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';

import { LayoutComponent } from './components/layout/layout.component';
import { ProjectsPageComponent } from './pages/projects/projects-page.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: ProjectsPageComponent },
      { path: '**', redirectTo: '' }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule
  ],
  exports: [ RouterModule ],
  declarations: [
    LayoutComponent, ProjectsPageComponent
  ],
  providers: []
})
export class ProjectsModule { }
