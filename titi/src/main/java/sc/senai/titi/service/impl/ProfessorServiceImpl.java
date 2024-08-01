package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.escola.EscolaRequestDto;
import sc.senai.titi.controller.dto.professor.ProfessorRequestDto;
import sc.senai.titi.model.Escola;
import sc.senai.titi.model.Professor;
import sc.senai.titi.repository.EscolaRepository;
import sc.senai.titi.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class ProfessorServiceImpl {

    @NonNull
    private ProfessorRepository professorRepository;

    public void cadastrarProfessor(ProfessorRequestDto professorRequestDto) {
        Professor professor = new Professor();
        professor.setNome(professorRequestDto.nome());
        professor.setEmail(professorRequestDto.email());
        professor.setTelefone(professorRequestDto.telefone());
        professor.setEndereco(professorRequestDto.endereco());
        professor.setEscola(professorRequestDto.escola());

        professorRepository.save(professor);
    }

    public List<Professor> buscarTodosProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessor(Long id) {
        return professorRepository.findById(id);
    }

    public void deletarProfessor(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
        }
    }

}
