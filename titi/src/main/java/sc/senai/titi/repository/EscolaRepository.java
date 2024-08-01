package sc.senai.titi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.titi.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
