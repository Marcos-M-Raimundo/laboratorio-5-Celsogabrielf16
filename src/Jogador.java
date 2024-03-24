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
        this.classe = new Classe("Sem classe");
        this.inventario = new Inventario(10);
    }
    
    // Retorna uma String com todos os atributos do jogador
    public String toString() {
        return "Classe: Jogador, propridades do jogador " + nome + ": " + nivel + " " + raca + " " + classe + " " + itemCabeca + " " + itemCorpo + " " + itemMaoDireita + " " + itemMaoEsquerda + " " + itemPe + "\n";
    }

    // Getters e setters para cada atributo do jogador
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return this.nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getRaca() {
        return this.raca;
    }
    
    public void setRaca(String raca) {
        this.raca = raca;
    }
        
    public String getClasse() {
        return this.classe;
    }
    
    public void setClasse(String classe) {
        this.classe = classe;
    }
        
    public String getItemCabeca() {
        return this.itemCabeca;
    }
    
    public void setItemCabeca(String itemCabeca) {
        this.itemCabeca = itemCabeca;
    }
        
    public String getItemCorpo() {
        return this.itemCorpo;
    }
    
    public void setItemCorpo(String itemCorpo) {
        this.itemCorpo = itemCorpo;
    }
        
    public String getItemMaoDireita() {
        return this.itemMaoDireita;
    }
    
    public void setItemMaoDireita(String itemMaoDireita) {
        this.itemMaoDireita = itemMaoDireita;
    }
        
    public String getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }
    
    public void setItemMaoEsquerda(String itemMaoEsquerda) {
        this.itemMaoEsquerda = itemMaoEsquerda;
    }
        
    public String getItemPe() {
        return this.itemPe;
    }
    
    public void setItemPe(String itemPe) {
        this.itemPe = itemPe;
    }
        
}
