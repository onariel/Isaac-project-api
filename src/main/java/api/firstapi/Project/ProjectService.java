package api.firstapi.Project;

import api.firstapi.Employee.*;
import api.firstapi.Task.Task;
import api.firstapi.Task.TaskDTO;
import api.firstapi.Task.TaskRepository;
import api.firstapi.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    @Lazy
    private TaskService taskService;


    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public boolean addEmployee(long id, String email){
        Project project = projectRepository.findById(id).orElse(null);
        Employee employee = employeeService.getEmployeeByEmail(email);
        if(employee != null) {
            project.getLinkedEmployees().add(employee);
            employee.getProjects().add(project);

            projectRepository.save(project);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public List<ProjectDTO> getProjectDTOById(long id){
        if(projectRepository.findAllByLinkedEmployees(id).orElse(null) != null) {
            List<ProjectDTO> projects = toProjectDTO(projectRepository.findAllByLinkedEmployees(id).orElse(null));
            return projects;
        }else{
            return null;
        }
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(false);
        Employee employee = employeeRepository.findById(projectDTO.getProjectManager().getId()).orElse(null);
        employee.getManagedProjects().add(project);
        project.setProjectManager(employee);
        project.setBudget(projectDTO.getBudget());
        project.getLinkedEmployees().add(employee);
        employee.getProjects().add(project);

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