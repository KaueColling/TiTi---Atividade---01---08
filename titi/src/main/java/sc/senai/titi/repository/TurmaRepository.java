package sc.senai.titi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.titi.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
