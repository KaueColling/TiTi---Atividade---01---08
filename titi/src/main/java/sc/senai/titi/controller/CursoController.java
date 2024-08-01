package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.curso.CursoRequestDto;
import sc.senai.titi.model.Curso;
import sc.senai.titi.service.impl.CursoServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    @NonNull
    private CursoServiceImpl cursoService;

    @PostMapping
    private String cadastrarCurso(@RequestBody CursoRequestDto cursoRequestDto) {
        cursoService.cadastrarCurso(cursoRequestDto);
        return "Curso de nome: " + cursoRequestDto.nome() + " foi criado com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Curso>> buscarTodosCursos() {
        return ResponseEntity.ok(cursoService.buscarTodosCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> buscarCurso(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarCurso(id));
    }

    @DeleteMapping("/{id}")
    public String deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return "Curso deletado com sucesso";
    }

}
