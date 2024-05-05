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
        this.setNivel(1);
        this.setRaca(Raca.HUMANO);
        this.setClasse(Classe.AVENTUREIRO);
        
        Inventario inventarioJogador = new Inventario(50);
        this.setInventario(inventarioJogador);

        this.setItemCabeca(null);
        this.setItemCorpo(null);
        this.setItemMaoDireita(null);
        this.setItemMaoEsquerda(null);
        this.setItemPe(null);
    }
    
    // Sobrecarrega o construtor anterior, recebe apenas o nome, nivel, raca, classe e inventario
    public Jogador(String nome, int nivel, Raca raca, Classe classe) {
        this.nome = nome;
        this.setNivel(nivel);
        this.setRaca(raca);
        this.setClasse(classe);
        
        Inventario inventarioJogador = new Inventario(50);
        this.setInventario(inventarioJogador);
        
        this.setItemCabeca(null);
        this.setItemCorpo(null);
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
            .append("\n- Nivel: ").append(this.getNivel())
            .append("\n- Raça: ").append(this.getRaca())
            .append("\n- Classe: ").append(this.getClasse())
            .append("\n- Inventário: ").append(this.getInventario())
            .append("\n- Item da Cabeça: ").append(this.getItemCabeca() != null ? this.getItemCabeca() : "Sem item equipado")
            .append("\n- Item do Corpo: ").append(this.getItemCorpo() != null ? this.getItemCorpo() : "Sem item equipado")
            .append("\n- Item da Mão Direita: ").append(this.getItemMaoDireita() != null ? this.getItemMaoDireita() : "Sem item equipado")
            .append("\n- Item da Mão Esquerda: ").append(this.getItemMaoEsquerda() != null ? this.getItemMaoEsquerda() : "Sem item equipado")
            .append("\n- Item do Pé: ").append(this.getItemPe() != null ? this.getItemPe() : "Sem item equipado");

        return stringBuilder.toString();
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

    // Verifica se alguma das maos do jogador esta vazia
    public boolean possuiMaoVazia() {
        if ((this.getItemMaoDireita() == null) || (this.getItemMaoEsquerda() == null)) {
            return true;
        }
        return false;
    }

    // Vende os itens de acordo com a lista recebida
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

        if (this.getItemCabeca() != null) itensEquipados.add(this.getItemCabeca());
        if (this.getItemCorpo() != null) itensEquipados.add(this.getItemCorpo());
        if (this.getItemMaoDireita() != null) itensEquipados.add(this.itemMaoDireita);
        if (this.getItemMaoEsquerda() != null) itensEquipados.add(this.itemMaoEsquerda);
        if (this.getItemPe() != null) itensEquipados.add(this.itemPe);

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

        if (item != null && item.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
            System.out.println();
        } else if (item != null && !this.verificaCompatibilidadePorClasse(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a classe " + this.getClasse() + "!");
            System.out.println();
        } else if (item != null && !this.verificaCompatibilidadePorRaca(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a raça " + this.getRaca() + "!");
            System.out.println();
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

    private void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }

    public void setItemCabeca (Item itemCabeca) {
        if (verificaItemPodeSerEquipado(itemCabeca)) {
            if (this.itemCabeca != null) this.getInventario().adicionarItem(this.itemCabeca);
            this.itemCabeca = itemCabeca;

            if (itemCabeca != null)
                this.getInventario().removerItem(itemCabeca.getNome());
        }
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }

    public void setItemCorpo (Item itemCorpo) {
        if (verificaItemPodeSerEquipado(itemCorpo)) {
            if (this.itemCorpo != null) this.getInventario().adicionarItem(this.itemCorpo);
            this.itemCorpo = itemCorpo;

            if (itemCorpo != null)
                this.getInventario().removerItem(itemCorpo.getNome());
        }
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        if (verificaItemPodeSerEquipado(itemMaoDireita)) {
            if (this.itemMaoDireita != null) this.getInventario().adicionarItem(this.itemMaoDireita);
            this.itemMaoDireita = itemMaoDireita;

            if (itemMaoDireita != null)
                this.getInventario().removerItem(itemMaoDireita.getNome());
        }
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda (Item itemMaoEsquerda) {
        if (verificaItemPodeSerEquipado(itemMaoEsquerda)) {
            if (this.itemMaoEsquerda != null) this.getInventario().adicionarItem(this.itemMaoEsquerda);
            this.itemMaoEsquerda = itemMaoEsquerda;

            if (itemMaoEsquerda != null)
                this.getInventario().removerItem(itemMaoEsquerda.getNome());
        }
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    public void setItemPe (Item itemPe) {
        if (verificaItemPodeSerEquipado(itemPe)) {
            if (this.itemPe != null) this.getInventario().adicionarItem(this.itemPe);
            this.itemPe = itemPe;

            if (itemPe != null)
                this.getInventario().removerItem(itemPe.getNome());
        }
    }
        
}