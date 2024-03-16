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

    public Jogador() {
        System.out.println("Classe jogador criada!");
    }

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
