package model;

import app.Classe;
import app.Inventario;
import app.Item;
import app.Jogo;
import app.Raca;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    private Item itemAcessorio;
    private Item itemCabeca;
    private Item itemCorpo;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    public Jogador(String nome, int nivel, Raca raca, Classe classe) {
        this.nome = nome;
        this.setNivel(nivel);
        this.setRaca(raca);
        this.setClasse(classe);
        
        Inventario inventarioJogador = new Inventario(50);
        this.setInventario(inventarioJogador);
        
        this.setItemCabeca(null);
        this.setItemCorpo(null);
        this.setItemAcessorio(null);
        this.setItemMaoDireita(null);
        this.setItemMaoEsquerda(null);
        this.setItemPe(null);
    }
    
    // Método padrao chamado quando imprimimos a classe Jogador
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Informações do jogador ").append(this.getNome())
            .append("\n- Poder: ").append(this.poderJogador())
            .append("\n- Nível: ").append(this.getNivel())
            .append("\n- Raça: ").append(this.getRaca())
            .append("\n- Classe: ").append(this.getClasse())
            .append("\n- Inventário: ").append(this.getInventario())
            .append("\n- Item da Cabeça: ").append(this.getItemCabeca() != null ? this.getItemCabeca() : "Sem item equipado")
            .append("\n- Item do Corpo: ").append(this.getItemCorpo() != null ? this.getItemCorpo() : "Sem item equipado")
            .append("\n- Acessório: ").append(this.getItemAcessorio() != null ? this.getItemAcessorio() : "Sem item equipado")
            .append("\n- Item da Mão Direita: ").append(this.getItemMaoDireita() != null ? this.getItemMaoDireita() : "Sem item equipado")
            .append("\n- Item da Mão Esquerda: ").append(this.getItemMaoEsquerda() != null ? this.getItemMaoEsquerda() : "Sem item equipado")
            .append("\n- Item do Pé: ").append(this.getItemPe() != null ? this.getItemPe() : "Sem item equipado");

        return stringBuilder.toString();
    }

    public static void lerJogadores(Jogo jogo, String path) {
        LerJogadores jogadores = new LerJogadores();
        jogadores.lerArquivo(jogo, path);
    }

    // Retorna o poder do jogador de acordo com seu nivel e o bonus de poder dos itens equipados pelo mesmo
    public int poderJogador() {
        List<Item> itensEquipados = this.getItensEquipados();
        int poderSomado = this.getNivel();

        for (Item item : itensEquipados) {
            poderSomado += item.getBonusPoder();
        }

        return poderSomado;
    }

    // Vende os itens de acordo com a lista recebida
    public String venderItens(List<Item> itensParaVender) {
        String mensagem;
        int valorTotalItens = 0;

        for (Item item : itensParaVender)
            valorTotalItens += item.getValor();

        if (valorTotalItens >= 1000) {
            this.getInventario().removerItem(itensParaVender.stream().map(Item::getNome).toList());

            int novoNivel = this.getNivel() + (valorTotalItens / 1000);
            setNivel(novoNivel);
            
            mensagem = "Os itens foram vendidos! O jogador " + this.getNome() + " foi para o nível " + this.getNivel() + "!\n";
        } else {
            mensagem = "Valor total dos itens insuficiente para a venda!\n";
        }

        return mensagem;
    }

    public String equipaItemCabeca (Item itemCabeca) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemCabeca);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemCabeca() != null)
                this.getInventario().adicionarItem(this.getItemCabeca());

            this.getInventario().removerItem(itemCabeca.getNome());
            this.setItemCabeca(itemCabeca);

            mensagem = this.getItemCabeca().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    public String equipaItemCorpo (Item itemCorpo) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemCorpo);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemCorpo() != null)
                this.getInventario().adicionarItem(this.getItemCorpo());

            this.getInventario().removerItem(itemCorpo.getNome());
            this.setItemCorpo(itemCorpo);

            mensagem = this.getItemCorpo().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    public String equipaItemAcessorio (Item itemAcessorio) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemAcessorio);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemAcessorio() != null)
                this.getInventario().adicionarItem(this.getItemAcessorio());

            this.getInventario().removerItem(itemAcessorio.getNome());
            this.setItemAcessorio(itemAcessorio);

            mensagem = this.getItemAcessorio().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    public String equipaItemMaoDireita (Item itemMaoDireita) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemMaoDireita);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemMaoDireita() != null)
                this.getInventario().adicionarItem(this.getItemMaoDireita());

            this.getInventario().removerItem(itemMaoDireita.getNome());
            this.setItemMaoDireita(itemMaoDireita);

            mensagem = this.getItemMaoDireita().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    public String equipaItemMaoEsquerda (Item itemMaoEsquerda) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemMaoEsquerda);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemMaoEsquerda() != null)
                this.getInventario().adicionarItem(this.getItemMaoEsquerda());

            this.getInventario().removerItem(itemMaoEsquerda.getNome());
            this.setItemMaoEsquerda(itemMaoEsquerda);

            mensagem = this.getItemMaoEsquerda().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    public String equipaItemPe (Item itemPe) {
        String mensagem;

        String mensagemVerificacao = verificaItemPodeSerEquipado(itemPe);
        if (mensagemVerificacao.equals("O item é válido!")) {
            if (this.getItemPe() != null)
                this.getInventario().adicionarItem(this.getItemPe());

            this.getInventario().removerItem(itemPe.getNome());
            this.setItemPe(itemPe);

            mensagem = this.getItemPe().getNome() + " equipado com sucesso!\n";
        } else {
            mensagem = mensagemVerificacao;
        }

        return mensagem;
    }

    // Verifica se o item dado pode ser equipado pelo jogador, 
    // verificanto se ja existem grande e sua compatibilidade por classe e raca
    private String verificaItemPodeSerEquipado(Item item) {
        String mensagem = "O item é válido!";

        if (item == null) {
            mensagem = "Este item não é valido!\n";
        } else if (!this.verificaCompatibilidadePorClasse(item)) {
            mensagem = "O item " + item.getNome() + " não é compativel com a classe " + this.getClasse() + "!\n";
        } else if (!this.verificaCompatibilidadePorRaca(item)) {
            mensagem = "O item " + item.getNome() + " não é compativel com a raça " + this.getRaca() + "!\n";
        } else if (item.getItemGrande() && this.verificaExisteItemGrande()) {
            mensagem = "O item " + item.getNome() + " não foi equipado pois não é possivel ter dois itens grandes equipados!\n";
        }

        return mensagem;
    }

    // Retorna uma lista com os itens atualmente equipados
    private List<Item> getItensEquipados() {
        List<Item> itensEquipados = new ArrayList<Item>();

        if (this.getItemCabeca() != null) itensEquipados.add(this.getItemCabeca());
        if (this.getItemCorpo() != null) itensEquipados.add(this.getItemCorpo());
        if (this.getItemAcessorio() != null) itensEquipados.add(this.getItemAcessorio());
        if (this.getItemMaoDireita() != null) itensEquipados.add(this.getItemMaoDireita());
        if (this.getItemMaoEsquerda() != null) itensEquipados.add(this.getItemMaoEsquerda());
        if (this.getItemPe() != null) itensEquipados.add(this.getItemPe());

        return itensEquipados;
    }

    // Verifica se ja existe algum item grande equipado
    private boolean verificaExisteItemGrande() {
        List<Item> itensEquipados = this.getItensEquipados();
        boolean jaExisteItemGrande = false;

        for (Item item : itensEquipados) {
            if (item.getItemGrande()) {
                jaExisteItemGrande = true;
                break;
            }
        }

        return jaExisteItemGrande;
    }

    // Verifica se a classe do item dado é compativel com a classe do jogador
    private boolean verificaCompatibilidadePorClasse(Item item) {
        boolean itemCompativel = false;
        
        for (Classe classeItem : item.getClassesCompativeis()) {
            if (classeItem == this.getClasse() || classeItem == Classe.AVENTUREIRO) {
                itemCompativel = true;
                break;
            };
        }
        
        return itemCompativel;
    }
    
    // Verifica se a raca do item dado é compativel com a raça do jogador
    private boolean verificaCompatibilidadePorRaca(Item item) {
        boolean itemCompativel = false;

        for (Raca racaItem : item.getRacasCompativeis()) {
            if (racaItem == this.getRaca() || racaItem == Raca.HUMANO) {
                itemCompativel = true;
                break;
            };
        }

        return itemCompativel;
    }

    // Getters e setters para cada atributo do jogador
    public String getNome() {
        return this.nome;
    }

    public int getNivel() {
        return this.nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Raca getRaca() {
        return this.raca;
    }
    
    public void setRaca(Raca raca) {
        this.raca = raca;
    }
        
    public Classe getClasse() {
        return this.classe;
    }
    
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
        
    public Inventario getInventario() {
        return this.inventario;
    }

    private void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }
    public void setItemCabeca (Item itemCabeca) {
        this.itemCabeca = itemCabeca;
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }

    private void setItemCorpo (Item itemCorpo) {
        this.itemCorpo = itemCorpo;
    }

    public Item getItemAcessorio() {
        return this.itemAcessorio;
    }

    private void setItemAcessorio (Item ItemAcessorio) {
        this.itemAcessorio = ItemAcessorio;
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        this.itemMaoDireita = itemMaoDireita;
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    private void setItemMaoEsquerda (Item itemMaoEsquerda) {
        this.itemMaoEsquerda = itemMaoEsquerda;
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    private void setItemPe (Item itemPe) {
        this.itemPe = itemPe;
    }
        
}