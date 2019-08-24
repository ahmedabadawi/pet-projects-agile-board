export interface ProjectsList {
  total: number;
  projects: Project[];
}

export interface Project {
  id: number;
  code: string;
  title: string;
  description: string;
  startDate: string;
  endDate: string;
  adminId: number;
}
