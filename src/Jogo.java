import java.util.List;

public class Jogo {
    private List<Jogador> jogadores;
    private Masmorra masmorra;

    public void jogo(List<Jogador> jogadores, Masmorra masmorra) {
        this.setJogadores(jogadores);
        this.setMasmorra(masmorra);
    }

    private List<Jogador> getJogadores() {
        return this.jogadores;
    }

    private void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    
    private Masmorra getMasmorra() {
        return this.masmorra;
    }

    private void setMasmorra(Masmorra masmorra) {
        this.masmorra = masmorra;
    }
}
