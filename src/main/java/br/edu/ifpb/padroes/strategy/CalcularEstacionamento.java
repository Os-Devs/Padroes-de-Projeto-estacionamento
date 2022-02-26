package br.edu.ifpb.padroes.strategy;

import java.math.BigDecimal;
import java.time.Duration;

public interface CalcularEstacionamento {
    /* 
        INTERFACE RESPONSÁVEL POR GERENCIAR OS CÁLCULOS DO ESTACIONAMENTO
        PELO SEU TIPO
    */

    public BigDecimal calcularValor(Duration duracao);
}
