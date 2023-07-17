package br.com.banco.domain.repositories;

import br.com.banco.domain.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findAllByDataTransferenciaBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Transferencia> findByNomeOperadorTransacao(String nomeDoOperador);

    List<Transferencia> findAllByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDate dataInicio, LocalDate plusDays, String nomeDoOperador);

}
