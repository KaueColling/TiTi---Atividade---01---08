package sc.senai.titi.service.impl;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.titi.controller.dto.aluno.AlunoResquestDto;
import sc.senai.titi.controller.dto.endereco.EnderecoRequestDto;
import sc.senai.titi.model.Aluno;
import sc.senai.titi.model.Endereco;
import sc.senai.titi.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class EnderecoServiceImpl {

    @NonNull
    private EnderecoRepository enderecoRepository;

    public void cadastrarEndereco(EnderecoRequestDto enderecoRequestDto) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoRequestDto.rua());
        endereco.setNumero(enderecoRequestDto.numero());
        endereco.setCidade(enderecoRequestDto.cidade());
        endereco.setEstado(enderecoRequestDto.estado());
        endereco.setBairro(enderecoRequestDto.bairro());
        endereco.setCep(enderecoRequestDto.cep());
        enderecoRepository.save(endereco);
    }

    public List<Endereco> buscarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEndereco(Long id) {
        return enderecoRepository.findById(id);
    }

    public void deletarEndereco(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        }
    }

}
