import java.util.List;

public class Jogador {
    private final String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    
    // Construtor que recebe todos os atributos do jogador
    public Jogador(String nome, int nivel, Raca raca, Classe classe, Inventario inventario) {
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.inventario = inventario;
    }

    // Construtor que recebe apenas o nome, no Munchkim caso o jogador nao tenha raça ele é humano, e todos os jogadores tem no minimo o nível 1
    public Jogador(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.raca = new Raca("Humana", "Sem poderes especiais", 5);
        this.inventario = new Inventario(10);
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
            .append(" }");
        return stringBuilder.toString();
    }

    // Retorna o poder do jogador de acordo com seu nivel e o bonus de poder dos itens equipados pelo mesmo
    public int poderJogador() {
        List<Item> itensEquipados = this.classe.getItensEquipados();
        int poderSomado = this.nivel;

        for (Item item : itensEquipados) {
            poderSomado += item.getBonusPoder();
        }

        return poderSomado;
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
        
}
