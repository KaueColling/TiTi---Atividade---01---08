package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.aluno.AlunoResquestDto;
import sc.senai.titi.model.Aluno;
import sc.senai.titi.model.Endereco;
import sc.senai.titi.repository.AlunoRepository;
import sc.senai.titi.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class AlunoServiceImpl {

    @NonNull
    private AlunoRepository alunoRepository;

    @NonNull
    private final EnderecoRepository enderecoRepository;

    public void cadastrarAluno(AlunoResquestDto alunoResquestDto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoResquestDto.nome());
        aluno.setEmail(alunoResquestDto.email());
        aluno.setTelefone(alunoResquestDto.telefone());
        aluno.setEndereco(alunoResquestDto.endereco());

        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAluno(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAluno(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
        }
    }
}
