package br.edu.padroes;

import br.edu.ifpb.padroes.Estacionamento;
import br.edu.ifpb.padroes.Veiculo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstacionamentoTest {

    private Estacionamento estacionamento    = new Estacionamento();

    // VALORES DUPLICADOS PARA NÃO INFLUENCIAR NO TEST
    private BigDecimal VALOR_HORA            = new BigDecimal("2.00");
    private BigDecimal VALOR_DIARIA          = new BigDecimal("26.00");
    private BigDecimal VALOR_MENSALIDADE     = new BigDecimal("300.00");


    @Test
    public void obterTotalAPagarTeste_hora() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime saida   = LocalDateTime.of(2021, 1, 1, 11, 0, 0);
        Veiculo veiculo       = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamento.setEntrada(entrada);
        estacionamento.setSaida(saida);
        estacionamento.setVeiculo(veiculo);

        try {
            System.out.println(String.format("R$ %.2f",estacionamento.obterTotalAPagar()));
            long diferenca = Duration.between(entrada, saida).toHours();
            assertEquals(estacionamento.obterTotalAPagar(),
                            VALOR_HORA.multiply(new BigDecimal(diferenca)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void obterTotalAPagarTeste_diaria() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime saida   = LocalDateTime.of(2021, 1, 12, 0, 0, 0);
        Veiculo veiculo       = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamento.setEntrada(entrada);
        estacionamento.setSaida(saida);
        estacionamento.setVeiculo(veiculo);

        try {
            System.out.println(String.format("R$ %.2f",estacionamento.obterTotalAPagar()));
            long diferenca = Duration.between(entrada, saida).toDays();
            assertEquals(estacionamento.obterTotalAPagar(),
                            VALOR_DIARIA.multiply(new BigDecimal(diferenca)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void obterTotalAPagarTeste_mensalidade() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 17, 0, 0, 0);
        LocalDateTime saida   = LocalDateTime.of(2021, 3, 1, 0, 0, 0);
        Veiculo veiculo       = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamento.setEntrada(entrada);
        estacionamento.setSaida(saida);
        estacionamento.setVeiculo(veiculo);


        try {
            System.out.println(String.format("R$ %.2f",estacionamento.obterTotalAPagar()));
            long diferenca  = (Duration.between(entrada, saida).toDays() / 30);
            assertEquals(estacionamento.obterTotalAPagar(),
                            VALOR_MENSALIDADE.multiply(new BigDecimal(diferenca)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}