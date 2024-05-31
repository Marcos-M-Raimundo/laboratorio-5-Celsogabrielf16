package controller;

import java.util.List;

import app.Classe;
import app.Inventario;
import app.Item;
import app.Jogo;
import app.Raca;
import model.Jogador;
import view.JogadorView;

public class JogadorController {
    public JogadorView jogadorView;
    public Jogador jogador;

    public JogadorController(JogadorView jogadorView, Jogador jogador) {
        this.jogadorView = jogadorView;
        this.jogador = jogador;
    }
    
    // Método padrao chamado quando imprimimos a classe Jogador
    @Override
    public String toString() {
        return this.jogador.toString();
    }

    public static void lerJogadores(Jogo jogo, String path) {
        Jogador.lerJogadores(jogo, path);
    }

    public int poderJogador() {
        return this.jogador.poderJogador();
    }

    // Vende os itens de acordo com a lista recebida
    public void venderItens(List<Item> itensParaVender) {
        String mensagem = this.jogador.venderItens(itensParaVender);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemCabeca (Item itemCabeca) {
        String mensagem = this.jogador.equipaItemCabeca(itemCabeca);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemCorpo (Item itemCorpo) {
        String mensagem = this.jogador.equipaItemCorpo(itemCorpo);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemAcessorio (Item itemAcessorio) {
        String mensagem = this.jogador.equipaItemAcessorio(itemAcessorio);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemMaoDireita (Item itemMaoDireita) {
        String mensagem = this.jogador.equipaItemMaoDireita(itemMaoDireita);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemMaoEsquerda (Item itemMaoEsquerda) {
        String mensagem = this.jogador.equipaItemMaoEsquerda(itemMaoEsquerda);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public void equipaItemPe (Item itemPe) {
        String mensagem = this.jogador.equipaItemPe(itemPe);
        this.jogadorView.exibirMensagem(mensagem);
    }

    public String getNome() {
        return this.jogador.getNome();
    }

    public int getNivel() {
        return this.jogador.getNivel();
    }

    public void setNivel(int nivel) {
        this.jogador.setNivel(nivel);
    }

    public Raca getRaca() {
        return this.jogador.getRaca();
    }
        
    public Classe getClasse() {
        return this.jogador.getClasse();
    }
        
    public Inventario getInventario() {
        return this.jogador.getInventario();
    }

    public Item getItemCabeca() {
        return this.jogador.getItemCabeca();
    }

    public Item getItemCorpo() {
        return this.jogador.getItemCorpo();
    }

    public Item getItemAcessorio() {
        return this.jogador.getItemAcessorio();
    }

    public Item getItemMaoDireita() {
        return this.jogador.getItemMaoDireita();
    }

    public Item getItemMaoEsquerda() {
        return this.jogador.getItemMaoEsquerda();
    }

    public Item getItemPe() {
        return this.jogador.getItemPe();
    }
    
}
