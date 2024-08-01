package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.professor.ProfessorRequestDto;
import sc.senai.titi.controller.dto.turma.TurmaRequestDto;
import sc.senai.titi.model.Professor;
import sc.senai.titi.model.Turma;
import sc.senai.titi.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class TurmaServiceImpl {

    @NonNull
    private TurmaRepository turmaRepository;

    public void cadastrarTurma(TurmaRequestDto turmaRequestDto) {
        Turma turma = new Turma();
        turma.setNome(turmaRequestDto.nome());
        turma.setEscola(turmaRequestDto.escola());
        turma.setListaDeAlunos(turmaRequestDto.listaDeAlunos());

        turmaRepository.save(turma);
    }

    public List<Turma> buscarTodasTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarTurma(Long id) {
        return turmaRepository.findById(id);
    }

    public void deletarTurma(Long id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
        }
    }

}
