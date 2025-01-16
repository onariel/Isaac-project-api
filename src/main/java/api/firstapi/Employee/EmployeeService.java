package api.firstapi.Employee;

import api.firstapi.RequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(String name, String email, String role, String password) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setRole(role);
        employee.setPassword(password);
        return employeeRepository.save(employee);
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

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
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
        if(employeeList != null) {
            for (Employee employee : employeeList) {
                employeeDTOList.add(toDTO(employee));
            }
        }
        return employeeDTOList;
    }

}