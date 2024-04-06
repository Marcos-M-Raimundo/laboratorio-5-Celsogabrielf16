import java.util.ArrayList;
import java.util.List;

public class Item {
    private final String nome;
    private final int bonusPoder;
    private final int valor;
    private final TipoItem tipo;
    private final boolean itemGrande;
    private final List<Classe> classesCompativeis;
    public final List<Raca> racasCompativeis;

    // Construtor que recebe todos os atributos do item
    public Item(String nome, int bonusPoder, int valor, TipoItem tipo, boolean itemGrande) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
        this.itemGrande = itemGrande;

        Classe classeGenerica = Classe.AVENTUREIRO;
        List<Classe> listaClassesCompativeis = new ArrayList<>(1);
        listaClassesCompativeis.add(classeGenerica);
        this.classesCompativeis = listaClassesCompativeis;

        Raca racaGenerica = Raca.HUMANO;
        List<Raca> listaRacasCompativeis = new ArrayList<>(1);
        listaRacasCompativeis.add(racaGenerica);
        this.racasCompativeis = listaRacasCompativeis;
    }

    // Construtor que recebe todos os atributos do item
    public Item(String nome, int bonusPoder, int valor, TipoItem tipo, boolean itemGrande, List<Classe> classesCompativeis, List<Raca> racasCompativeis) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
        this.itemGrande = itemGrande;
        this.classesCompativeis = classesCompativeis;
        this.racasCompativeis = racasCompativeis;
    }

    // Método padrao chamado quando imprimimos a classe Item
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item { ")
            .append("Nome: ").append(this.nome)
            .append(", Bonus de poder: ").append(this.bonusPoder)
            .append(", Valor: ").append(this.valor)
            .append(", Tipo: ").append(this.tipo)
            .append(", É um item grande? ").append(this.itemGrande)
            .append(", Classes compativeis: ").append(this.classesCompativeis)
            .append(", Raças compativeis: ").append(this.racasCompativeis)
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

    public TipoItem getTipo() {
        return this.tipo;
    }

    public boolean getItemGrande() {
        return this.itemGrande;
    }

    public List<Classe> getClassesCompativeis() {
        return this.classesCompativeis;
    }

    public List<Raca> getRacasCompativeis() {
        return this.racasCompativeis;
    }
}
