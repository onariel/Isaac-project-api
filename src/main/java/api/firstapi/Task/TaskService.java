package api.firstapi.Task;

import api.firstapi.Project.Project;
import api.firstapi.Project.ProjectDTO;
import api.firstapi.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    @Lazy
    private ProjectService projectService;

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskDTO createTask(TaskDTO taskDTO, long projectId) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(taskDTO.getStatus());
        Project project = projectService.getProjectById(projectId).orElse(null);
        task.setProject(project);
        task.setBudget(taskDTO.getBudget());
        project.getTasks().add(task);
        return toDTO(taskRepository.save(task));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setBudget(task.getBudget());
        return taskDTO;
    }

    public List<TaskDTO> toDTO(List<Task> tasks) {
        List<TaskDTO> taskDTOs = new ArrayList<>();
        if (tasks != null) {
            for (Task task : tasks) {
                taskDTOs.add(toDTO(task));
            }
        }
        return taskDTOs;
    }
}