package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.aluno.AlunoResquestDto;
import sc.senai.titi.model.Aluno;
import sc.senai.titi.service.impl.AlunoServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    @NonNull
    private AlunoServiceImpl alunoService;

    @PostMapping
    private String cadastrarAluno(@RequestBody AlunoResquestDto alunoResquestDto) {
        alunoService.cadastrarAluno(alunoResquestDto);
        return "Aluno de nome: " + alunoResquestDto.nome() + " foi criada com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodosAlunos() {
        return ResponseEntity.ok(alunoService.buscarTodosAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> buscarAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarAluno(id));
    }

    @DeleteMapping("/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return "Aluno deletado com sucesso";
    }


}
