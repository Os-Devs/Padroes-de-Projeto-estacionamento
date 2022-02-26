package br.edu.ifpb.padroes.strategy;

import java.math.BigDecimal;
import java.time.Duration;

public class CalcularHora implements CalcularEstacionamento {

    final BigDecimal VALOR_HORA = new BigDecimal("2.00");

    @Override
    public BigDecimal calcularValor(Duration duracao) {
        return VALOR_HORA.multiply(new BigDecimal(duracao.toHours()));
    }
}
