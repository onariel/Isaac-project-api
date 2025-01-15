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

    @PostMapping("/create") // Endpoint pour créer un nouveau membre
    public long createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee.getName(), employee.getEmail(), employee.getRole(), employee.getPassword()).getId();
    }

    @PostMapping("/login")
    public Employee login(@RequestBody RequestLogin login) {
        Employee employee = employeeService.getEmployeeByEmail(login.getEmail());
        if (employee != null && employee.getPassword().equals(login.getPassword())) {
            Employee employeeWithoutPassword = new Employee();
            employeeWithoutPassword.setId(employee.getId());
            employeeWithoutPassword.setName(employee.getName());
            employeeWithoutPassword.setEmail(employee.getEmail());
            employeeWithoutPassword.setRole(employee.getRole());
            return employeeWithoutPassword;
        } else {
            return null;
        }
    }
}