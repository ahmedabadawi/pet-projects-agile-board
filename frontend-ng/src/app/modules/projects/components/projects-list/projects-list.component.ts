import { Component, OnInit } from '@angular/core';

import { MatTableDataSource } from '@angular/material/table';

import { ConfigService } from '../../../core';
import { LogService } from '../../../core';

import { Project, ProjectsList } from '../../models/project.model';
import { ProjectService } from '../../services/project.service';

@Component({
  templateUrl: './projects-list.component.html',
  styleUrls: ['./projects-list.component.scss']
})
export class ProjectsListComponent implements OnInit {
  displayedColumns = [ 'id', 'code', 'title', 'description', 'startDate', 'endDate', 'adminId' ];
  dataSource: MatTableDataSource<Project>;

  loading = false;

  constructor(private projectService: ProjectService,
              private config: ConfigService,
              private log: LogService) { }

  ngOnInit() {
    this.loadProjects();
  }

  private loadProjects() {
    this.loading = true;
    this.projectService.getProjects()
      .subscribe(
        (response: ProjectsList) => {
          this.dataSource = new MatTableDataSource<Project>(response.projects);
          this.loading = false;
        },
        (error) => {
          this.log.error(error);
          this.loading = false;
        });
  }
}
