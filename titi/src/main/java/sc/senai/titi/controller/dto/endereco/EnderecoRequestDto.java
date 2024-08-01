package sc.senai.titi.controller.dto.endereco;

public record EnderecoRequestDto(
    String rua,
    Long numero,
    String cidade,
    String estado,
    String bairro,
    Long cep
) {
}
