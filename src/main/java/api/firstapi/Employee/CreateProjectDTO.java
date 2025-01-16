package api.firstapi.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectDTO {
    public int id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public Boolean status;
    public long projectManagerId;
    public float budget;
}
