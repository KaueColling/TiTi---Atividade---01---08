package sc.senai.titi.controller.dto.aluno;

import sc.senai.titi.model.Endereco;

public record AlunoResquestDto(
        String nome,
        String email,
        String telefone,
        Endereco endereco
) {
}
