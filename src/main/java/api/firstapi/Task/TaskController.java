package api.firstapi.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/Task") // URL de base pour les endpoints de cette classe
public class TaskController {

    @Autowired // Injection du service
    private TaskService projectService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}") // Endpoint pour récupérer un membre par ID
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/create") // Endpoint pour créer un nouveau membre
    public long createTask(@RequestBody Task Task) {
        return 0;
    }
}