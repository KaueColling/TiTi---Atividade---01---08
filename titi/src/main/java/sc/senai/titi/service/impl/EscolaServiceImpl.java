package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.disciplina.DisciplinaRequestDto;
import sc.senai.titi.controller.dto.escola.EscolaRequestDto;
import sc.senai.titi.model.Disciplina;
import sc.senai.titi.model.Escola;
import sc.senai.titi.repository.CursoRepository;
import sc.senai.titi.repository.EscolaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class EscolaServiceImpl {

    @NonNull
    private EscolaRepository escolaRepository;

    public void cadastrarEscola(EscolaRequestDto escolaRequestDto) {
        Escola escola = new Escola();
        escola.setNome(escolaRequestDto.nome());
        escola.setEndereco(escolaRequestDto.endereco());
        escola.setEmail(escolaRequestDto.email());
        escola.setListaDeCursoEscola(escolaRequestDto.listaDeCursoEscola());

        escolaRepository.save(escola);
    }

    public List<Escola> buscarTodasEscolas() {
        return escolaRepository.findAll();
    }

    public Optional<Escola> buscarEscola(Long id) {
        return escolaRepository.findById(id);
    }

    public void deletarEscola(Long id) {
        if (escolaRepository.existsById(id)) {
            escolaRepository.deleteById(id);
        }
    }


}
