package sc.senai.titi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Escola {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Endereco endereco;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    private List<Professor> listaDeProfessoresEscola;

    @ManyToMany
    private List<Curso> listaDeCursoEscola;

}
