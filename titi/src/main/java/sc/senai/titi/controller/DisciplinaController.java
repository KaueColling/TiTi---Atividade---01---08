package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.disciplina.DisciplinaRequestDto;
import sc.senai.titi.model.Disciplina;
import sc.senai.titi.service.impl.DisciplinaServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    @NonNull
    private DisciplinaServiceImpl disciplinaService;

    @PostMapping
    private String cadastrarDisciplina(@RequestBody DisciplinaRequestDto disciplinaRequestDto) {
        disciplinaService.cadastrarDisciplina(disciplinaRequestDto);
        return "Disciplina de nome: " + disciplinaRequestDto.nome() + " foi criado com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> buscarTodasDisciplinas() {
        return ResponseEntity.ok(disciplinaService.buscarTodasDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Disciplina>> buscarDisciplina(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.buscarDisciplina(id));
    }

    @DeleteMapping("/{id}")
    public String deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplina(id);
        return "Disciplina deletado com sucesso";
    }

}
