package api.firstapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);// Recherche un membre par son ID (Select by id en SQL)
    Optional<Employee> findByEmail(String email);
}