package api.firstapi.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findById(Long id);// Recherche un project par son ID (Select by id en SQL)

    @Query("SELECT p FROM Project p JOIN p.linkedEmployees e WHERE e.id = :employeeId")
    Optional<List<Project>> findAllByLinkedEmployees(@Param("employeeId") Long employeeId);
}