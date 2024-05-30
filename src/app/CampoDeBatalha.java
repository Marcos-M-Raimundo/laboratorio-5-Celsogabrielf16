package app;

import model.Jogador;

import java.util.Random;

public class CampoDeBatalha {
    // Implementa a logica de batalha entre o jogador e o monstro
    public static Resultado batalhaContraMonstro(Monstro monstro, Jogador jogador) {
        Resultado resultado;
        
        if (jogador.poderJogador() > monstro.getPoder()) {
            resultado = Resultado.VITORIA;
        } else {
            Random random = new Random();
            int resultadoDado = random.nextInt(1,7);

            if (resultadoDado >= 5) {
                resultado = Resultado.FUGA;
            } else {
                resultado = Resultado.DERROTA;
            }
        }

        return resultado;
    }
}
