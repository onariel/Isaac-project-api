package api.firstapi.Project;

import api.firstapi.Employee.CreateProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/¨Project") // URL de base pour les endpoints de cette classe
public class ProjectController {

    @Autowired // Injection du service
    private ProjectService projectService;

    @GetMapping("/{id}") // Endpoint pour récupérer un membre par ID
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/create") // Endpoint pour créer un nouveau membre
    public ProjectDTO createProject(@RequestBody CreateProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }
}