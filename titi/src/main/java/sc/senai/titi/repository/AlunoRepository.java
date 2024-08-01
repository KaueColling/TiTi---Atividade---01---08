package sc.senai.titi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.titi.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>  {
}
