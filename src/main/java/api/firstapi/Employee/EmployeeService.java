package api.firstapi.Employee;

import api.firstapi.RequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired // Injection du repository
    private EmployeeRepository employeeRepository;


    public EmployeeDTO getEmployeeById(Long id) {
        return toDTO(employeeRepository.findById(id).orElse(null)); // Retourne le membre correspondant à l'ID ou null
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(String name, String email, String role, String password) {
        Employee employee = new Employee();
        employee.setName(name); // Définit le nom du membre
        employee.setEmail(email);
        employee.setRole(role);
        employee.setPassword(password);
        return employeeRepository.save(employee); // Sauvegarde le membre dans la base
    }

    public Long login(RequestLogin requestLogin) {
        Employee employee = getEmployeeByEmail(requestLogin.getEmail());
        if (employee == null) {
            return null;
        }
        if(employee.getPassword().equals(requestLogin.getPassword())){
            return employee.getId();
        }
        return null;

    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setRole(employee.getRole());
        return employeeDTO;
    }

    public List<EmployeeDTO> toDTO(List<Employee> employeeList){
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
        employeeDTOList.add(toDTO(employee));
        }
        return employeeDTOList;
    }

    }
