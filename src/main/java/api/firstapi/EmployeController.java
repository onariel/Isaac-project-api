package api.firstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/Employee") // URL de base pour les endpoints de cette classe
public class EmployeController {

    @Autowired // Injection du service
    private EmployeeService employeeService;

    @GetMapping("/{id}") // Endpoint pour récupérer un membre par ID
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping // Endpoint pour créer un nouveau membre
    public long createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee.getName(), employee.getEmail(), employee.getRole(), employee.getPassword()).getId();
    }
}