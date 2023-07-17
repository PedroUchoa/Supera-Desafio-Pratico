package br.com.banco.domain.dtos;

import br.com.banco.domain.entities.Transferencia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DadosTransferencia {

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;

    public DadosTransferencia(Transferencia transferencia){
        this.dataTransferencia = transferencia.getDataTransferencia();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
    }


}
