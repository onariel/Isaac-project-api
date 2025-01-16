package api.firstapi.Project;

import api.firstapi.Employee.Employee;
import api.firstapi.Task.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Project {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
    public int id;

    public String name;

    public String description;

    public Date startDate;

    public Date endDate;

    public Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    public Employee projectManager;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Employee> linkedEmployees;

    @OneToMany
    public List<Task> tasks;

    public float budget;

    public Project(int id, String name, String description, Date startDate, Date endDate, Boolean status, Employee projectManager, List<Employee> linkedEmployees, List<Task> tasks, float budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projectManager = projectManager;
        this.linkedEmployees = linkedEmployees;
        this.tasks = tasks;
        this.budget = budget;
    }

    public Project() {
        this.linkedEmployees = new ArrayList<>();
    }
}