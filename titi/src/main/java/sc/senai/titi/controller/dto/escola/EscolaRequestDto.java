package sc.senai.titi.controller.dto.escola;

import sc.senai.titi.model.Curso;
import sc.senai.titi.model.Endereco;
import sc.senai.titi.model.Professor;

import java.util.List;

public record EscolaRequestDto(
        String nome,
        Endereco endereco,
        String email,
        List<Professor> listaDeProfessoresEscola,
        List<Curso> listaDeCursoEscola
) {
}
