package br.com.banco.domain.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "conta")
@Entity(name = "Conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idConta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private String nomeResponsavel;


}
