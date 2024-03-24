import java.util.ArrayList;
import java.util.List;

public class Guerreiro extends Classe {
    private Item itemCabeca;
    private Item itemCorpo;
    
    public Guerreiro(String descricao) {
        super(descricao);
    }

    public Guerreiro(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
    }

    // Método padrao chamado quando imprimimos a classe Guerreiro
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Guerreiro { ")
            .append("Descrição: ").append(this.getDescricao())
            .append(", Item da mão direita: ").append(this.getItemMaoDireita())
            .append(", Item da mão esquerda: ").append(this.getItemMaoEsquerda())
            .append(", Item do pé: ").append(this.getItemPe())
            .append(", Item do cabeça: ").append(this.itemCabeca)
            .append(", Item do corpo: ").append(this.itemCorpo)
            .append(" }");
        return stringBuilder.toString();
    }

    // Sopreescreve o metodo da classe Classe e retorna uma lista com os item atualmente equipados
    @Override
    public List<Item> getItensEquipados() {
        List<Item> itensEquipados = new ArrayList<>();
        if (this.getItemMaoDireita() != null) itensEquipados.add(this.getItemMaoDireita());
        if (this.getItemMaoEsquerda() != null) itensEquipados.add(this.getItemMaoEsquerda());
        if (this.getItemPe() != null) itensEquipados.add(this.getItemPe());
        if (this.itemCabeca != null) itensEquipados.add(this.itemCabeca);
        if (this.itemCorpo != null) itensEquipados.add(this.itemCorpo);
        return itensEquipados;
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

    public void setItemCorpo (Item itemCorpo) {
        this.itemCorpo = itemCorpo;
    }
}
