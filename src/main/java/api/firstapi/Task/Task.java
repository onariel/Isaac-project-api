package api.firstapi.Task;

import api.firstapi.Employee.Employee;
import api.firstapi.Project.Project;
import api.firstapi.Usefule_object;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    public String description;

    public int priority;

    public Date dueDate;

    public Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    public Project project;

    public float budget;
}