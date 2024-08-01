package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.escola.EscolaRequestDto;
import sc.senai.titi.model.Escola;
import sc.senai.titi.service.impl.EscolaServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/escola")
public class EscolaController {

    @NonNull
    private EscolaServiceImpl escolaService;

    @PostMapping
    private String cadastrarEscola(@RequestBody EscolaRequestDto escolaRequestDto) {
        escolaService.cadastrarEscola(escolaRequestDto);
        return "Escola de nome: " + escolaRequestDto.nome() + " foi criado com sucesso";
    }

    @GetMapping
    public ResponseEntity<List<Escola>> buscarTodasEscolas() {
        return ResponseEntity.ok(escolaService.buscarTodasEscolas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Escola>> buscarEscola(@PathVariable Long id) {
        return ResponseEntity.ok(escolaService.buscarEscola(id));
    }

    @DeleteMapping("/{id}")
    public String deletarEscola(@PathVariable Long id) {
        escolaService.deletarEscola(id);
        return "Escola deletado com sucesso";
    }

}
