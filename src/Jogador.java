public class Jogador {
    private String nome;
    private int nivel;
    private String raca;
    private String classe;
    private String itemCabeca;
    private String itemCorpo;
    private String itemMaoDireita;
    private String itemMaoEsquerda;
    private String itemPe;
    
    // Construtor que recebe todos os atributos do jogador
    public Jogador(String nome, int nivel, String raca, String classe, String itemCabeca, String itemCorpo, String itemMaoDireita, String itemMaoEsquerda, String itemPe) {
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }

    // Construtor que recebe apenas o nome, no Munchkim caso o jogador nao tenha raça ele é humano, e todos os jogadores tem no minimo o nível 1
    public Jogador(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.raca = "Humano";
        this.classe = "";
        this.itemCabeca = "";
        this.itemCorpo = "";
        this.itemMaoDireita = "";
        this.itemMaoEsquerda = "";
        this.itemPe = "";
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
