package sc.senai.titi.controller.dto.curso;

import sc.senai.titi.model.Disciplina;

import java.util.List;

public record CursoRequestDto(
    String nome,
    List<Disciplina> listaDeDisciplina
) {
}
