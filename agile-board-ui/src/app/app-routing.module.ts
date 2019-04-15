import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';

import { LoginModule } from './modules/login/login.module';
import { HomeModule } from './modules/home/home.module';
import { BoardModule } from './modules/board/board.module';
import { ProjectsModule } from './modules/projects/projects.module';
import { AdminModule } from './modules/admin/admin.module';

const routes: Routes = [
  { path: 'login', loadChildren: () => LoginModule },
  { path: 'home', loadChildren: () => HomeModule },
  { path: 'projects', loadChildren: () => ProjectsModule },
  { path: 'board', loadChildren: () => BoardModule },
  { path: 'admin', loadChildren: () => AdminModule },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes/*, {
      preloadingStrategy: PreloadAllModules
    }*/)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
