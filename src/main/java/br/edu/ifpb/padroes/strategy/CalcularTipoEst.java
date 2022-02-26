package br.edu.ifpb.padroes.strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class CalcularTipoEst {

    public CalcularEstacionamento tpEstPorInterval(LocalDateTime entrada, LocalDateTime saida) {
        /* 
            CASO SEJA CRIADO UM NOVO TIPO DE ESTACIONAMENTO ESPECIFICAR UM NOVO INTERVALO 
            E CRIAR UMA CLASSE EXCLUSIVA PARA TRATAR O CÁLCULO DA MESMA E SER INSTANCIADA NA FACTORY
        */

        Duration duracao = Duration.between(entrada, saida);


        /* 
            SABER DADO O INTERVALO QUAL CÁLCULO SERÁ USADO PARA O MESMO     
        */
        if (duracao.toHours() < 24) {

            return new CalcularHora();

        } 
        else if (duracao.toDays() < 30) {

            return new CalcularDiaria();

        } 
        else if (duracao.toDays() >= 30) {

            return new CalcularMensalidade();

        }

        return null;

    }
    
}
