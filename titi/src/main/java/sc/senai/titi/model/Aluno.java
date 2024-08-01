package sc.senai.titi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import sc.senai.titi.controller.dto.aluno.AlunoRequestGetDto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aluno {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @ManyToOne
    private Endereco endereco;

}
