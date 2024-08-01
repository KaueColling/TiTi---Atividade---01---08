package sc.senai.titi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.titi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
