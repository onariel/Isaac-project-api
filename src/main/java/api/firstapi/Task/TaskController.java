package api.firstapi.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GETTERS
    @GetMapping("/{id}/name")
    public ResponseEntity<String> getTaskName(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getName()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/description")
    public ResponseEntity<String> getTaskDescription(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getDescription()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/priority")
    public ResponseEntity<Integer> getTaskPriority(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getPriority()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/dueDate")
    public ResponseEntity<Date> getTaskDueDate(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getDueDate()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> getTaskStatus(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getStatus()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/budget")
    public ResponseEntity<Float> getTaskBudget(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task.getBudget()))
                .orElse(ResponseEntity.notFound().build());
    }


    // SETTERS
    @PostMapping("/{id}/name")
    public ResponseEntity<String> setTaskName(@PathVariable Long id, @RequestBody String name) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setName(name);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(name);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/description")
    public ResponseEntity<String> setTaskDescription(@PathVariable Long id, @RequestBody String description) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setDescription(description);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(description);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/priority")
    public ResponseEntity<Integer> setTaskPriority(@PathVariable Long id, @RequestBody Integer priority) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setPriority(priority);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(priority);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/dueDate")
    public ResponseEntity<Date> setTaskDueDate(@PathVariable Long id, @RequestBody Date dueDate) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setDueDate(dueDate);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(dueDate);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<Boolean> setTaskStatus(@PathVariable Long id, @RequestBody Boolean status) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setStatus(status);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(status);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/budget")
    public ResponseEntity<Float> setTaskBudget(@PathVariable Long id, @RequestBody Float budget) {
        return taskService.getTaskById(id)
                .map(task -> {
                    task.setBudget(budget);
                    taskService.saveTask(task);
                    return ResponseEntity.ok(budget);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}