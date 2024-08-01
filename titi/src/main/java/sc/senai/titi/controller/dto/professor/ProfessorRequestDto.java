package sc.senai.titi.controller.dto.professor;

import sc.senai.titi.model.Disciplina;
import sc.senai.titi.model.Endereco;
import sc.senai.titi.model.Escola;

import java.util.List;

public record ProfessorRequestDto(
       Long id,
       String nome,
       String email,
       String telefone,
       Escola escola,
       List<Disciplina> listaDeDisciplina,
       Endereco endereco
) {
}
