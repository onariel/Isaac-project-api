package api.firstapi.Project;

import api.firstapi.Employee.*;
import api.firstapi.Task.Task;
import api.firstapi.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Indique que cette classe est un service Spring
public class ProjectService {

    @Autowired // Injection du repository
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    public ProjectDTO getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(this::toProjectDTO).orElse(null);
    }



    public ProjectDTO createProject(CreateProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(false);
        project.setProjectManager(employeeRepository.findById(projectDTO.getProjectManagerId()).orElse(null));
        project.setBudget(projectDTO.getBudget());

        return toProjectDTO(projectRepository.save(project));
    }

    public ProjectDTO toProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setStartDate(project.getStartDate());
        projectDTO.setEndDate(project.getEndDate());
        projectDTO.setProjectManager(employeeService.toDTO(project.getProjectManager()));
        projectDTO.setBudget(project.getBudget());
        projectDTO.setStatus(project.getStatus());
        projectDTO.setLinkedEmployees(employeeService.toDTO(project.getLinkedEmployees()));
        projectDTO.setTasks(taskService.toDTO(project.getTasks()));

        return projectDTO;

    }

    public List<ProjectDTO> toProjectDTO(List<Project> projects) {
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        for (Project project : projects) {
            projectDTOs.add(toProjectDTO(project));
        }
        return projectDTOs;
    }
}