package sc.senai.titi.controller.dto.turma;

import sc.senai.titi.model.Aluno;
import sc.senai.titi.model.Escola;

import java.util.List;

public record TurmaRequestDto(
        String nome,
        Escola escola,
        List<Aluno> listaDeAlunos
) {
}
