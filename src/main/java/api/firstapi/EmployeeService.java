package api.firstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indique que cette classe est un service Spring
public class EmployeeService {

    @Autowired // Injection du repository
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null); // Retourne le membre correspondant à l'ID ou null
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }

    public Employee createEmployee(String name, String email, String role, String password) {
        Employee employee = new Employee();
        employee.setName(name); // Définit le nom du membre
        employee.setEmail(email);
        employee.setRole(role);
        employee.setPassword(password);
        return employeeRepository.save(employee); // Sauvegarde le membre dans la base
    }
}