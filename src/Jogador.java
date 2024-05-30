import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    private Item itemAcessorio;
    private Item itemCabeca;
    private Item itemCorpo;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    public Jogador(String nome, int nivel, Raca raca, Classe classe) {
        this.nome = nome;
        this.setNivel(nivel);
        this.setRaca(raca);
        this.setClasse(classe);
        
        Inventario inventarioJogador = new Inventario(50);
        this.setInventario(inventarioJogador);
        
        this.setItemCabeca(null);
        this.setItemCorpo(null);
        this.setItemAcessorio(null);
        this.setItemMaoDireita(null);
        this.setItemMaoEsquerda(null);
        this.setItemPe(null);
    }
    
    // Método padrao chamado quando imprimimos a classe Jogador
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Informações do jogador ").append(this.getNome())
            .append("\n- Poder: ").append(this.poderJogador())
            .append("\n- Nível: ").append(this.getNivel())
            .append("\n- Raça: ").append(this.getRaca())
            .append("\n- Classe: ").append(this.getClasse())
            .append("\n- Inventário: ").append(this.getInventario())
            .append("\n- Item da Cabeça: ").append(this.getItemCabeca() != null ? this.getItemCabeca() : "Sem item equipado")
            .append("\n- Item do Corpo: ").append(this.getItemCorpo() != null ? this.getItemCorpo() : "Sem item equipado")
            .append("\n- Acessório: ").append(this.getItemAcessorio() != null ? this.getItemAcessorio() : "Sem item equipado")
            .append("\n- Item da Mão Direita: ").append(this.getItemMaoDireita() != null ? this.getItemMaoDireita() : "Sem item equipado")
            .append("\n- Item da Mão Esquerda: ").append(this.getItemMaoEsquerda() != null ? this.getItemMaoEsquerda() : "Sem item equipado")
            .append("\n- Item do Pé: ").append(this.getItemPe() != null ? this.getItemPe() : "Sem item equipado");

        return stringBuilder.toString();
    }

    // Retorna o poder do jogador de acordo com seu nivel e o bonus de poder dos itens equipados pelo mesmo
    public int poderJogador() {
        List<Item> itensEquipados = this.getItensEquipados();
        int poderSomado = this.getNivel();

        for (Item item : itensEquipados) {
            poderSomado += item.getBonusPoder();
        }

        return poderSomado;
    }

    // Verifica se alguma das maos do jogador esta vazia
    public boolean possuiMaoVazia() {
        if ((this.getItemMaoDireita() == null) || (this.getItemMaoEsquerda() == null)) {
            return true;
        }
        return false;
    }

    // Vende os itens de acordo com a lista recebida
    public void venderItens(List<Item> itensParaVender) {
        int valorTotalItens = 0;

        for (Item item : itensParaVender)
            valorTotalItens += item.getValor();

        if (valorTotalItens >= 1000) {
            this.getInventario().removerItem(itensParaVender.stream().map(Item::getNome).toList());

            int novoNivel = this.getNivel() + (valorTotalItens / 1000);
            setNivel(novoNivel);
            
            System.out.println("Os itens foram vendidos! O jogador " + this.getNome() + " foi para o nível " + this.getNivel() + "!");
        } else {
            System.out.println("Valor total dos itens insuficiente para a venda!");
        }
    }

    // Retorna uma lista com os itens atualmente equipados
    private List<Item> getItensEquipados() {
        List<Item> itensEquipados = new ArrayList<Item>();

        if (this.getItemCabeca() != null) itensEquipados.add(this.getItemCabeca());
        if (this.getItemCorpo() != null) itensEquipados.add(this.getItemCorpo());
        if (this.getItemAcessorio() != null) itensEquipados.add(this.getItemAcessorio());
        if (this.getItemMaoDireita() != null) itensEquipados.add(this.getItemMaoDireita());
        if (this.getItemMaoEsquerda() != null) itensEquipados.add(this.getItemMaoEsquerda());
        if (this.getItemPe() != null) itensEquipados.add(this.getItemPe());

        return itensEquipados;
    }

    // Verifica se ja existe algum item grande equipado
    private boolean verificaExisteItemGrande() {
        List<Item> itensEquipados = this.getItensEquipados();
        boolean jaExisteItemGrande = false;

        for (Item item : itensEquipados) {
            if (item.getItemGrande()) {
                jaExisteItemGrande = true;
                break;
            }
        }

        return jaExisteItemGrande;
    }

    // Verifica se a classe do item dado é compativel com a classe do jogador
    private boolean verificaCompatibilidadePorClasse(Item item) {
        boolean itemCompativel = false;
        
        for (Classe classeItem : item.getClassesCompativeis()) {
            if (classeItem == this.getClasse() || classeItem == Classe.AVENTUREIRO) {
                itemCompativel = true;
                break;
            };
        }
        
        return itemCompativel;
    }
    
    // Verifica se a raca do item dado é compativel com a raça do jogador
    private boolean verificaCompatibilidadePorRaca(Item item) {
        boolean itemCompativel = false;

        for (Raca racaItem : item.getRacasCompativeis()) {
            if (racaItem == this.getRaca() || racaItem == Raca.HUMANO) {
                itemCompativel = true;
                break;
            };
        }

        return itemCompativel;
    }

    // Verifica se o item dado pode ser equipado pelo jogador, 
    // verificanto se ja existem grande e sua compatibilidade por classe e raca
    public boolean verificaItemPodeSerEquipado(Item item) {
        boolean itemValido = false;

        if (item == null) {
            System.out.println("Este item não é valido!\n");
        } else if (!this.verificaCompatibilidadePorClasse(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a classe " + this.getClasse() + "!\n");
        } else if (!this.verificaCompatibilidadePorRaca(item)) {
            System.out.println("O item " + item.getNome() + " não é compativel com a raça " + this.getRaca() + "!\n");
        } else if (item.getItemGrande() && this.verificaExisteItemGrande()) {
            System.out.println("O item " + item.getNome() + " não foi equipado pois não é possivel ter dois itens grandes equipados!\n");
        } else {
            itemValido = true;
        }

        return itemValido;
    }

    public boolean equipaItemCabeca (Item itemCabeca) {
        if (verificaItemPodeSerEquipado(itemCabeca)) {
            if (this.getItemCabeca() != null) {
                System.out.println("O item " + this.getItemCabeca() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemCabeca());
            }

            this.getInventario().removerItem(itemCabeca.getNome());
            this.setItemCabeca(itemCabeca);

            return true;
        }

        return false;
    }

    public boolean equipaItemCorpo (Item itemCorpo) {
        if (verificaItemPodeSerEquipado(itemCorpo)) {
            if (this.getItemCorpo() != null) {
                System.out.println("O item " + this.getItemCorpo() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemCorpo());
            }

            this.getInventario().removerItem(itemCorpo.getNome());
            this.setItemCorpo(itemCorpo);

            return true;
        }

        return false;
    }

    public boolean equipaItemAcessorio (Item itemAcessorio) {
        if (verificaItemPodeSerEquipado(itemAcessorio)) {
            if (this.getItemAcessorio() != null) {
                System.out.println("O item " + this.getItemAcessorio() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemAcessorio());
            }

            this.getInventario().removerItem(itemAcessorio.getNome());
            this.setItemAcessorio(itemAcessorio);

            return true;
        }

        return false;
    }

    public boolean equipaItemMaoDireita (Item itemMaoDireita) {
        if (verificaItemPodeSerEquipado(itemMaoDireita)) {
            if (this.getItemMaoDireita() != null) {
                System.out.println("O item " + this.getItemMaoDireita() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemMaoDireita());
            }

            this.getInventario().removerItem(itemMaoDireita.getNome());
            this.setItemMaoDireita(itemMaoDireita);

            return true;
        }

        return false;
    }

    public boolean equipaItemMaoEsquerda (Item itemMaoEsquerda) {
        if (verificaItemPodeSerEquipado(itemMaoEsquerda)) {
            if (this.getItemMaoEsquerda() != null) {
                System.out.println("O item " + this.getItemMaoEsquerda() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemMaoEsquerda());
            }

            this.getInventario().removerItem(itemMaoEsquerda.getNome());
            this.setItemMaoEsquerda(itemMaoEsquerda);

            return true;
        }

        return false;
    }

    public boolean equipaItemPe (Item itemPe) {
        if (verificaItemPodeSerEquipado(itemPe)) {
            if (this.getItemPe() != null){
                System.out.println("O item " + this.getItemPe() + " estava equipado e foi devolvido ao inventário!");
                this.getInventario().adicionarItem(this.getItemPe());
            }

            this.getInventario().removerItem(itemPe.getNome());
            this.setItemPe(itemPe);

            return true;
        }

        return false;
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

    private void setInventario(Inventario inventario) {
        this.inventario = inventario;
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

    private void setItemCorpo (Item itemCorpo) {
        this.itemCorpo = itemCorpo;
    }

    public Item getItemAcessorio() {
        return this.itemAcessorio;
    }

    private void setItemAcessorio (Item ItemAcessorio) {
        this.itemAcessorio = ItemAcessorio;
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        if (this.getItemMaoDireita() != null) {
            System.out.println("O item " + this.getItemMaoDireita() + " estava equipado e foi devolvido ao inventário!");
            this.getInventario().adicionarItem(this.getItemMaoDireita());
        }
        
        if (itemMaoDireita != null)
            this.getInventario().removerItem(itemMaoDireita.getNome());
            
        this.itemMaoDireita = itemMaoDireita;
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda (Item itemMaoEsquerda) {
        if (this.getItemMaoEsquerda() != null) {
            System.out.println("O item " + this.getItemMaoEsquerda() + " estava equipado e foi devolvido ao inventário!");
            this.getInventario().adicionarItem(this.getItemMaoEsquerda());
        }
        
        if (itemMaoEsquerda != null)
            this.getInventario().removerItem(itemMaoEsquerda.getNome());

        this.itemMaoEsquerda = itemMaoEsquerda;
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    private void setItemPe (Item itemPe) {
        this.itemPe = itemPe;
    }
        
}