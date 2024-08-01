package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.professor.ProfessorRequestDto;
import sc.senai.titi.model.Professor;
import sc.senai.titi.service.impl.ProfessorServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    @NonNull
    private ProfessorServiceImpl professorService;

    @PostMapping
    private String cadastrarProfessor(@RequestBody ProfessorRequestDto professorRequestDto) {
        professorService.cadastrarProfessor(professorRequestDto);
        return "Professor de nome: " + professorRequestDto.nome() + " foi criado com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodosProfessores() {
        return ResponseEntity.ok(professorService.buscarTodosProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> buscarProfessor(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.buscarProfessor(id));
    }

    @DeleteMapping("/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return "Professpr deletado com sucesso";
    }

}
