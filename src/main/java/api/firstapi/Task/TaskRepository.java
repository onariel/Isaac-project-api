package api.firstapi.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findById(Long id);// Recherche un membre par son ID (Select by id en SQL)

}