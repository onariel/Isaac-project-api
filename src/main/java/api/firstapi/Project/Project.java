package api.firstapi.Project;

import api.firstapi.Employee.Employee;
import api.firstapi.Task.Task;
import api.firstapi.Usefule_object;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
}