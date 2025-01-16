package api.firstapi.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    public int id;

    public String name;

    public String description;

    public int priority;

    public Date dueDate;

    public Long status;

    public float budget;
}
