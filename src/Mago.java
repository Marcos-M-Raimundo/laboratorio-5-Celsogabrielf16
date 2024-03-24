import java.util.ArrayList;
import java.util.List;

public class Mago extends Classe {
    private Item itemCabeca;

    public Mago(String descricao) {
        super(descricao);
    }

    public Mago(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        if (itemCabeca != null) setItemCabeca(itemCabeca);
    }

    // Método padrao chamado quando imprimimos a classe Mago
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mago { ")
            .append("Descrição: ").append(this.getDescricao())
            .append(", Item da mão direita: ").append(this.getItemMaoDireita())
            .append(", Item da mão esquerda: ").append(this.getItemMaoEsquerda())
            .append(", Item do pé: ").append(this.getItemPe())
            .append(", Item da cabeça: ").append(this.itemCabeca)
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
        return itensEquipados;
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }

    public void setItemCabeca (Item itemCabeca) {
        if(itemCabeca.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("Não é possível ter dois itens grandes equipados!");
        } else if (!this.itemCompativel(itemCabeca)) {
            System.out.println("O item " + itemCabeca.getNome() + " não é compativel com a classe Mago!");
        } else {
            this.itemCabeca = itemCabeca;
        }
    }
}
