package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.curso.CursoRequestDto;
import sc.senai.titi.controller.dto.disciplina.DisciplinaRequestDto;
import sc.senai.titi.model.Curso;
import sc.senai.titi.model.Disciplina;
import sc.senai.titi.repository.CursoRepository;
import sc.senai.titi.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class DisciplinaServiceImpl {

    @NonNull
    private DisciplinaRepository disciplinaRepository;

    public void cadastrarDisciplina(DisciplinaRequestDto disciplinaRequestDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaRequestDto.nome());
        disciplina.setListaDeProfessores(disciplinaRequestDto.listaDeProfessores());

        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> buscarTodasDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplina(Long id) {
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplina(Long id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
        }
    }

}
