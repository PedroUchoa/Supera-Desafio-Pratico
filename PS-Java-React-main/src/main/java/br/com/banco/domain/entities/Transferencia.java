package br.com.banco.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Table(name = "transferencia")
@Entity(name = "Transferencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta contaId;

}
