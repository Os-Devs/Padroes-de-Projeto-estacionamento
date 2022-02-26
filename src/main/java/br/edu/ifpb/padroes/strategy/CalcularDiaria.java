package br.edu.ifpb.padroes.strategy;

import java.math.BigDecimal;
import java.time.Duration;

public class CalcularDiaria implements CalcularEstacionamento {

    final BigDecimal VALOR_DIARIA = new BigDecimal("26.00");

    @Override
    public BigDecimal calcularValor(Duration duracao) {
        return VALOR_DIARIA.multiply(new BigDecimal(duracao.toDays()));
    }
}
