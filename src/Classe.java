import java.util.ArrayList;
import java.util.List;

public class Classe {
    private final String descricao;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    public Classe(String descricao) {
        this.descricao = descricao;
    }

    public Classe(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        this.descricao = descricao;
        if (itemMaoDireita != null) setItemMaoDireita(itemMaoDireita);
        if (itemMaoEsquerda != null) setItemMaoEsquerda(itemMaoEsquerda);
        if (itemPe != null) setItemPe(itemPe);
    }

    // Método padrao chamado quando imprimimos a classe Classe
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classe { ")
            .append("Descricao: ").append(this.descricao)
            .append(", Item da mão direita: ").append(this.itemMaoDireita)
            .append(", Item da mão esquerda: ").append(this.itemMaoEsquerda)
            .append(", Item do pe: ").append(this.itemPe)
            .append(" }");
        return stringBuilder.toString();
    }

    // Verifica se alguma das mãos do jogador está vazia
    public boolean possuiMaoVazia() {
        if ((this.itemMaoDireita == null) || (this.itemMaoEsquerda == null)) {
            return true;
        }
        return false;
    }

    // Retorna uma lista com os item atualmente equipados
    public List<Item> getItensEquipados() {
        List<Item> itensEquipados = new ArrayList<>();
        if (this.itemMaoDireita != null) itensEquipados.add(this.itemMaoDireita);
        if (this.itemMaoEsquerda != null) itensEquipados.add(this.itemMaoEsquerda);
        if (this.itemPe != null) itensEquipados.add(this.itemPe);
        return itensEquipados;
    }

    protected boolean verificaExisteItemGrande() {
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

    protected boolean itemCompativel(Item item) {
        boolean itemCompativel = false;

        for (Classe classe : item.getClassesCompativeis()) {
            if (classe.getDescricao().equals(this.getDescricao())) itemCompativel = true;
        }

        return itemCompativel;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        if(itemMaoDireita.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
        } else if (!this.itemCompativel(itemMaoDireita)) {
            System.out.println("O item " + itemMaoDireita.getNome() + " não é compativel com a classe do jogador!");
        } else {
            this.itemMaoDireita = itemMaoDireita;
        }
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda (Item itemMaoEsquerda) {
        if(itemMaoEsquerda.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
        } else {
            this.itemMaoEsquerda = itemMaoEsquerda;
        }
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    public void setItemPe (Item itemPe) {
        if(itemPe.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
        } else {
            this.itemPe = itemPe;
        }
    }
}
