package br.com.banco.domain.controller;


import br.com.banco.domain.dtos.DadosTransferencia;
import br.com.banco.domain.servicies.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {


    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<DadosTransferencia>> getAllTransferencias(){
        List<DadosTransferencia> transferencias = transferenciaService.getAllTransferencias();
        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping
    @RequestMapping("/{nomeOperador}")
    public ResponseEntity<List<DadosTransferencia>> getByNomeDoOperador(@PathVariable String nomeOperador){
        List<DadosTransferencia> transferencias = transferenciaService.getByNomeDoOperador(nomeOperador);
        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping
    @RequestMapping("/{dataInicio}/{dataFim}")
    public ResponseEntity<List<DadosTransferencia>> getByData(@PathVariable(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio, @PathVariable(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dataFim){
        List<DadosTransferencia> transferencias = transferenciaService.getByData(dataInicio,dataFim);
        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping
    @RequestMapping("/{dataInicio}/{dataFim}/{nomeOperador}")
    public ResponseEntity<List<DadosTransferencia>> getByDataAndOperador(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dataFim, @PathVariable String nomeOperador){
        List<DadosTransferencia> transferencias = transferenciaService.getByDataAndOperador(dataInicio,dataFim,nomeOperador);
        return ResponseEntity.ok().body(transferencias);
    }

}
