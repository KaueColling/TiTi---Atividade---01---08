package sc.senai.titi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.titi.controller.dto.endereco.EnderecoRequestDto;
import sc.senai.titi.model.Endereco;
import sc.senai.titi.service.impl.EnderecoServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {

    @NonNull
    private EnderecoServiceImpl enderecoService;

    @PostMapping
    private String cadastrarEndereco(@RequestBody EnderecoRequestDto enderecoRequestDto) {
        enderecoService.cadastrarEndereco(enderecoRequestDto);
        return "Endereco de rua: " + enderecoRequestDto.rua() + " foi criada com sucesso";
    }
    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodosEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> buscarEndereco(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarEndereco(id));
    }

    @DeleteMapping("/{id}")
    public String deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return "Endereco deletado com sucesso";
    }

}
