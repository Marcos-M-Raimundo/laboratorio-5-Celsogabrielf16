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

    public int getNivel() {
        return this.nivel;
    }

    public String getRaca() {
        return this.raca;
    }
    
    public String getClasse() {
        return this.classe;
    }
    
    public String getItemCabeca() {
        return this.itemCabeca;
    }
    
    public String getItemCorpo() {
        return this.itemCorpo;
    }
    
    public String getItemMaoDireita() {
        return this.itemMaoDireita;
    }
    
    public String getItemMaoesquerda() {
        return this.itemMaoEsquerda;
    }
    
    public String getItemPe() {
        return this.itemPe;
    }
    
}
