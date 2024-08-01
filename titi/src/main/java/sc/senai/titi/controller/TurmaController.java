package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.turma.TurmaRequestDto;
import sc.senai.titi.model.Turma;
import sc.senai.titi.service.impl.TurmaServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turma")
public class TurmaController {

    @NonNull
    private TurmaServiceImpl turmaService;

    @PostMapping
    private String cadastrarTurma(@RequestBody TurmaRequestDto turmaRequestDto) {
        turmaService.cadastrarTurma(turmaRequestDto);
        return "Turma de nome: " + turmaRequestDto.nome() + " foi criado com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodasTurmas() {
        return ResponseEntity.ok(turmaService.buscarTodasTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> buscarTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.buscarTurma(id));
    }

    @DeleteMapping("/{id}")
    public String deletarTurma(@PathVariable Long id) {
        turmaService.deletarTurma(id);
        return "Professpr deletado com sucesso";
    }

}
