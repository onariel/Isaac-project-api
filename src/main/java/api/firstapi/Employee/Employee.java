package api.firstapi.Employee;

import api.firstapi.Project.Project;
import api.firstapi.Usefule_object;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity // Annotation pour indiquer que cette classe est une entité JPA
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@NoArgsConstructor // Génère un constructeur sans arguments
@Data
public class Employee {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
    private Long id;

    public String name;

    @Column(unique = true)
    public String email;

    public String role;

    public String password;

    @OneToMany()
    public List<Project> managedProjects;

    @ManyToMany
    public List<Project> projects;
}