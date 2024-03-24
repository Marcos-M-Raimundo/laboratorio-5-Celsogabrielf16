import java.util.List;

public class Item {
    private final String nome;
    private int bonusPoder;
    private int valor;
    private String tipo;
    private boolean itemGrande;
    private List<Classe> classesCompativeis;

    // Construtor que recebe todos os atributos do item
    public Item(String nome, int bonusPoder, int valor, String tipo, boolean itemGrande, List<Classe> classesCompativeis) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
        this.itemGrande = itemGrande;
        this.classesCompativeis = classesCompativeis;
    }

    // Método padrao chamado quando imprimimos a classe Item
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item { ")
            .append("Nome do item: ").append(this.nome)
            .append(", Bonus de poder do item: ").append(this.bonusPoder)
            .append(", Valor do item: ").append(this.valor)
            .append(", Tipo do item: ").append(this.tipo)
            .append(", É um item grande? ").append(this.itemGrande)
            .append(", Classes compativeis do item: ").append(this.classesCompativeis)
            .append(" }");
        return stringBuilder.toString();
    }

    // Getters para cada atributo do item
    public String getNome() {
        return this.nome;
    }

    public int getBonusPoder() {
        return this.bonusPoder;
    }

    public int getValor() {
        return this.valor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean getItemGrande() {
        return this.itemGrande;
    }

    public List<Classe> getClassesCompativeis() {
        return this.classesCompativeis;
    }
}
