package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.strategy.CalcularEstacionamento;
import br.edu.ifpb.padroes.strategy.CalcularTipoEst;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class Estacionamento {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    // RESPONSÁVEL POR FAZER O CÁLCULO

    private CalcularEstacionamento calc;

    // DESCOBRIR O TIPO DO ESTACIONAMENTO

    private CalcularTipoEst tpEst = new CalcularTipoEst();

/*  
    FUNÇÃO ERA RESPONSÁVEL POR CALCULAR INTERVALO E AINDA CALCULAR O PREÇO
    AGORA SERÁ RESPONSÁVEL APENAS POR RETORNAR O PREÇO 
*/

    public BigDecimal obterTotalAPagar() throws Exception {

        BigDecimal valor = new BigDecimal("0");

        assert (this.entrada != null && this.saida != null && this.veiculo != null);
        
        // SAÍDA FOR MENOR QUE A ENTRADA
        if (entrada.isAfter(saida)) {
            throw new Exception("Datas inválidas");
        }
        else {
            setCalc(tpEst.tpEstPorInterval(entrada, saida));
            valor = calc.calcularValor(Duration.between(this.entrada, this.saida));
        }

        /* CALCULAVA O VALOR PORÉM FOI PASSADO PARA UMA INTERFACE ESSE PROCESSO DE CÁLCULO
        
        if (periodoHoras < 12) {
            valor = VALOR_HORA.multiply(new BigDecimal(periodoHoras));
        } else if (periodoHoras > 12 && periodoDias < 15) {
            valor = VALOR_DIARIA.multiply(new BigDecimal(periodoDias));
        } else if (periodoDias > 15) {
            valor = VALOR_MENSALIDADE;
        } 
        */

        return valor;

    }

}