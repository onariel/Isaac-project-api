package api.firstapi.Employee;

import api.firstapi.Project.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private EmployeeDTO employee;
    private List<ProjectDTO> employees;
}
