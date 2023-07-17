package br.com.banco.domain.servicies;

import br.com.banco.domain.dtos.DadosTransferencia;
import br.com.banco.domain.repositories.TransferenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<DadosTransferencia> getAllTransferencias() {
        return transferenciaRepository.findAll().stream().map(DadosTransferencia::new).collect(Collectors.toList());
    }

    public List<DadosTransferencia> getByNomeDoOperador(String nomeDoOperador){
        return transferenciaRepository.findByNomeOperadorTransacao(nomeDoOperador).stream().map(DadosTransferencia::new).collect(Collectors.toList());
    }

    public List<DadosTransferencia> getByData(LocalDate dataInicio, LocalDate dataFim){
        return transferenciaRepository.findAllByDataTransferenciaBetween(dataInicio,dataFim.plusDays(1)).stream().map(DadosTransferencia::new).collect(Collectors.toList());
    }

    public List<DadosTransferencia> getByDataAndOperador(LocalDate dataInicio, LocalDate dataFim,String nomeOperador){
        return transferenciaRepository.findAllByDataTransferenciaBetweenAndNomeOperadorTransacao(dataInicio,dataFim, nomeOperador).stream().map(DadosTransferencia::new).collect(Collectors.toList());
    }


}
