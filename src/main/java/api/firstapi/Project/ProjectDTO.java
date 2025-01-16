package api.firstapi.Project;

import api.firstapi.Employee.EmployeeDTO;
import api.firstapi.Task.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    public int id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public Boolean status;
    public EmployeeDTO projectManager;
    public List<EmployeeDTO> linkedEmployees;
    public List<TaskDTO> tasks;
    public float budget;
}
