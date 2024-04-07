import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    private Item itemCabeca;
    private Item itemCorpo;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    // Construtor que recebe apenas o nome, no Munchkim caso o jogador nao tenha raça ele é humano, e todos os jogadores tem no minimo o nível 1
    public Jogador(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.raca = Raca.HUMANO;
        this.classe = Classe.AVENTUREIRO;
        this.inventario = new Inventario(50);
        this.itemCabeca = null;
        this.itemCorpo = null;
        this.itemMaoDireita = null;
        this.itemMaoEsquerda = null;
        this.itemPe = null;
    }
    
    // Construtor que recebe todos os atributos do jogador
    public Jogador(String nome, int nivel, Raca raca, Classe classe, Inventario inventario, Item itemCabeca, Item itemCorpo, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.inventario = inventario;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }
    
    // Método padrao chamado quando imprimimos a classe Jogador
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Jogador { ")
            .append("Nome: ").append(this.nome)
            .append(", Nivel: ").append(this.nivel)
            .append(", Raça: ").append(this.raca)
            .append(", Classe: ").append(this.classe)
            .append(", Inventário: ").append(this.inventario)
            .append(", Item da Cabeça: ").append(this.itemCabeca)
            .append(", Item do Corpo: ").append(this.itemCorpo)
            .append(", Item da Mão Direita: ").append(this.itemMaoDireita)
            .append(", Item da Mão Esquerda: ").append(this.itemMaoEsquerda)
            .append(", Item do Pé: ").append(this.itemPe)
            .append(" }");
        return stringBuilder.toString();
    }

    // Retorna o poder do jogador de acordo com seu nivel e o bonus de poder dos itens equipados pelo mesmo
    public int poderJogador() {
        List<Item> itensEquipados = this.getItensEquipados();
        int poderSomado = this.nivel;

        for (Item item : itensEquipados) {
            poderSomado += item.getBonusPoder();
        }

        return poderSomado;
    }

    public boolean possuiMaoVazia() {
        if ((this.itemMaoDireita == null) || (this.itemMaoEsquerda == null)) {
            return true;
        }
        return false;
    }

    public void venderItens(List<Item> itensParaVender) {
        int valorTotalItens = 0;

        for (Item item : itensParaVender) {
            valorTotalItens += item.getValor();
        }

        if (valorTotalItens >= 1000) {
            this.getInventario().removerItem(itensParaVender.stream().map(Item::getNome).toList());

            int novoNivel = this.getNivel() + (valorTotalItens / 1000);
            setNivel(novoNivel);
            
            System.out.println("Os itens foram vendidos! O jogador " + this.getNome() + " foi para o nível " + this.getNivel() + "!");
        } else {
            System.out.println("Valor total dos itens insuficiente para a venda!");
        }
    }

    // Retorna uma lista com os itens atualmente equipados
    private List<Item> getItensEquipados() {
        List<Item> itensEquipados = new ArrayList<Item>();
        if (this.itemCabeca != null) itensEquipados.add(this.itemCabeca);
        if (this.itemCorpo != null) itensEquipados.add(this.itemCorpo);
        if (this.itemMaoDireita != null) itensEquipados.add(this.itemMaoDireita);
        if (this.itemMaoEsquerda != null) itensEquipados.add(this.itemMaoEsquerda);
        if (this.itemPe != null) itensEquipados.add(this.itemPe);
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
            if (classeItem == this.getClasse()) {
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
            if (racaItem == this.getRaca()) {
                itemCompativel = true;
                break;
            };
        }

        return itemCompativel;
    }

    // Verifica se o item dado pode ser equipado pelo jogador, 
    // verificanto se ja existem grande e sua compatibilidade por classe e raca
    private boolean verificaItemPodeSerEquipado(Item item) {
        boolean itemValido = false;

        if(item.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
        } else if (!this.verificaCompatibilidadePorClasse(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a classe " + this.getClasse() + "!");
        } else if (!this.verificaCompatibilidadePorRaca(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a raça " + this.getRaca() + "!");
        } else {
            itemValido = true;
        }

        return itemValido;
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

    public Item getItemCabeca() {
        return this.itemCabeca;
    }

    public void setItemCabeca (Item itemCabeca) {
        if (verificaItemPodeSerEquipado(itemCabeca)) {
            if (this.itemCabeca != null) this.inventario.adicionarItem(this.itemCabeca);
            this.itemCabeca = itemCabeca;
            this.inventario.removerItem(itemCabeca.getNome());
        }
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }

    public void setItemCorpo (Item itemCorpo) {
        if (verificaItemPodeSerEquipado(itemCorpo)) {
            if (this.itemCorpo != null) this.inventario.adicionarItem(this.itemCorpo);
            this.itemCorpo = itemCorpo;
            this.inventario.removerItem(itemCorpo.getNome());
        }
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        if (verificaItemPodeSerEquipado(itemMaoDireita)) {
            if (this.itemMaoDireita != null) this.inventario.adicionarItem(this.itemMaoDireita);
            this.itemMaoDireita = itemMaoDireita;
            this.inventario.removerItem(itemMaoDireita.getNome());
        }
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda (Item itemMaoEsquerda) {
        if (verificaItemPodeSerEquipado(itemMaoEsquerda)) {
            if (this.itemMaoEsquerda != null) this.inventario.adicionarItem(this.itemMaoEsquerda);
            this.itemMaoEsquerda = itemMaoEsquerda;
            this.inventario.removerItem(itemMaoEsquerda.getNome());
        }
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    public void setItemPe (Item itemPe) {
        if (verificaItemPodeSerEquipado(itemPe)) {
            if (this.itemPe != null) this.inventario.adicionarItem(this.itemPe);
            this.itemPe = itemPe;
            this.inventario.removerItem(itemPe.getNome());
        }
    }
        
}
