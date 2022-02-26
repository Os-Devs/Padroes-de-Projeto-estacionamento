package br.edu.ifpb.padroes.strategy;

import java.math.BigDecimal;
import java.time.Duration;

public class CalcularMensalidade implements CalcularEstacionamento {

    final BigDecimal VALOR_MENSALIDADE = new BigDecimal("300.00");

    @Override
    public BigDecimal calcularValor(Duration duracao) {
        return VALOR_MENSALIDADE.multiply(new BigDecimal((duracao.toDays() / 30)));
    }
}
