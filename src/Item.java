import java.util.ArrayList;
import java.util.List;

public class Item {
    private final String nome;
    private int bonusPoder;
    private int valor;
    private TipoItem tipo;
    private boolean itemGrande;
    private List<Classe> classesCompativeis;
    public List<Raca> racasCompativeis;

    // Construtor que recebe todos os atributos do item
    public Item(String nome, int bonusPoder, int valor, TipoItem tipo, boolean itemGrande) {
        this.nome = nome;
        this.setBonusPoder(bonusPoder);
        this.setValor(valor);
        this.setTipo(tipo);
        this.setItemGrande(itemGrande);;

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
        this.setBonusPoder(bonusPoder);
        this.setValor(valor);
        this.setTipo(tipo);
        this.setItemGrande(itemGrande);
        this.setClassesCompativeis(classesCompativeis);
        this.setRacasCompativeis(racasCompativeis);
    }

    // Método padrao chamado quando imprimimos a classe Item
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getNome()).append(" - nível ").append(this.getBonusPoder());
        return stringBuilder.toString();
    }

    // Getters para cada atributo do item
    public String getNome() {
        return this.nome;
    }

    public int getBonusPoder() {
        return this.bonusPoder;
    }

    private void setBonusPoder(int bonusPoder) {
        this.bonusPoder = bonusPoder;
    }

    public int getValor() {
        return this.valor;
    }
    
    private void setValor(int valor) {
        this.valor = valor;
    }

    public TipoItem getTipo() {
        return this.tipo;
    }
    
    private void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public boolean getItemGrande() {
        return this.itemGrande;
    }

    public void setItemGrande(boolean itemGrande) {
        this.itemGrande = itemGrande;
    }

    public List<Classe> getClassesCompativeis() {
        return this.classesCompativeis;
    }
    
    private void setClassesCompativeis(List<Classe> classesCompativeis) {
        this.classesCompativeis = classesCompativeis;
    }

    public List<Raca> getRacasCompativeis() {
        return this.racasCompativeis;
    }
    
    private void setRacasCompativeis(List<Raca> racasCompativeis) {
        this.racasCompativeis = racasCompativeis;
    }
}
