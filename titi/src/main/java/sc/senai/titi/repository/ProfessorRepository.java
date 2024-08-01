package sc.senai.titi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.titi.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
