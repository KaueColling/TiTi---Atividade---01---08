package sc.senai.titi.controller.dto.disciplina;

import sc.senai.titi.model.Professor;

import java.util.List;

public record DisciplinaRequestDto(
        String nome,
        List<Professor> listaDeProfessores
) {
}
