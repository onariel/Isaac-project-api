package api.firstapi.Employee;

import api.firstapi.RequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeController {

    @Autowired
    private EmployeeService employeeService;

    // GETTERS
    @GetMapping("/{id}/name")
    public ResponseEntity<String> getEmployeeName(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok(employee.getName()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byEmail")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@RequestParam String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee != null) {
            return ResponseEntity.ok(employeeService.toDTO(employee));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if no employee found
        }
    }

    @GetMapping("/{id}/email")
    public ResponseEntity<String> getEmployeeEmail(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok(employee.getEmail()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/role")
    public ResponseEntity<String> getEmployeeRole(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok(employee.getRole()))
                .orElse(ResponseEntity.notFound().build());
    }

    // SETTERS
    @PostMapping("/{id}/name")
    public ResponseEntity<String> setEmployeeName(@PathVariable Long id, @RequestBody String name) {
        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setName(name);
                    employeeService.saveEmployee(employee);
                    return ResponseEntity.ok(name);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/{id}/email")
    public ResponseEntity<String> setEmployeeEmail(@PathVariable Long id, @RequestBody String email) {
        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setEmail(email);
                    employeeService.saveEmployee(employee);
                    return ResponseEntity.ok(email);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/role")
    public ResponseEntity<String> setEmployeeRole(@PathVariable Long id, @RequestBody String role) {
        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setRole(role);
                    employeeService.saveEmployee(employee);
                    return ResponseEntity.ok(role);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public Long login(@RequestBody RequestLogin login) {
        return employeeService.login(login);
    }

    @PostMapping("/create") // Endpoint pour créer un nouveau membre
    public long createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee.getName(), employee.getEmail(), employee.getRole(), employee.getPassword()).getId();
    }


}