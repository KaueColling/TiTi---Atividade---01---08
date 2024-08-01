package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.curso.CursoRequestDto;
import sc.senai.titi.model.Aluno;
import sc.senai.titi.model.Curso;
import sc.senai.titi.model.Disciplina;
import sc.senai.titi.repository.CursoRepository;
import sc.senai.titi.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class CursoServiceImpl {

    @NonNull
    private CursoRepository cursoRepository;

    public void cadastrarCurso(CursoRequestDto cursoRequestDto) {
        Curso curso = new Curso();
        curso.setNome(cursoRequestDto.nome());
        curso.setListaDeDisciplina(cursoRequestDto.listaDeDisciplina());

        cursoRepository.save(curso);
    }

    public List<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarCurso(Long id) {
        return cursoRepository.findById(id);
    }

    public void deletarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        }
    }


}
