package api.firstapi.Employee;

import api.firstapi.RequestLogin;
import api.firstapi.Usefule_object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/Employee") // URL de base pour les endpoints de cette classe
public class EmployeController {

    @Autowired // Injection du service
    private EmployeeService employeeService;

    @GetMapping("/{id}") // Endpoint pour récupérer un membre par ID
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create") // Endpoint pour créer un nouveau membre
    public long createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee.getName(), employee.getEmail(), employee.getRole(), employee.getPassword()).getId();
    }

    @PostMapping("/login")
    public Long login(@RequestBody RequestLogin login) {
        return employeeService.login(login);
    }
}