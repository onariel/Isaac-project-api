package api.firstapi.Project;

import api.firstapi.Project.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GETTERS
    @GetMapping("/{id}/name")
    public ResponseEntity<String> getProjectName(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getName()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/description")
    public ResponseEntity<String> getProjectDescription(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getDescription()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/startDate")
    public ResponseEntity<Date> getProjectStartDate(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getStartDate()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/endDate")
    public ResponseEntity<Date> getProjectEndDate(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getEndDate()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> getProjectStatus(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getStatus()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/budget")
    public ResponseEntity<Float> getProjectBudget(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project.getBudget()))
                .orElse(ResponseEntity.notFound().build());
    }

    // SETTERS
    @PostMapping("/{id}/name")
    public ResponseEntity<String> setProjectName(@PathVariable Long id, @RequestBody String name) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setName(name);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(name);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/{id}/description")
    public ResponseEntity<String> setProjectDescription(@PathVariable Long id, @RequestBody String description) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setDescription(description);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(description);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/startDate")
    public ResponseEntity<Date> setProjectStartDate(@PathVariable Long id, @RequestBody Date startDate) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setStartDate(startDate);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(startDate);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/{id}/endDate")
    public ResponseEntity<Date> setProjectEndDate(@PathVariable Long id, @RequestBody Date endDate) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setEndDate(endDate);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(endDate);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/{id}/status")
    public ResponseEntity<Boolean> setProjectStatus(@PathVariable Long id, @RequestBody Boolean status) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setStatus(status);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(status);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/budget")
    public ResponseEntity<Float> setProjectBudget(@PathVariable Long id, @RequestBody Float budget) {
        return projectService.getProjectById(id)
                .map(project -> {
                    project.setBudget(budget);
                    projectService.saveProject(project);
                    return ResponseEntity.ok(budget);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }
}