public class Main {
    public static void main(String[] args) {
        // Instanciação dos objetos para teste
        Jogador jogador1 = new Jogador("Celso", 16, "Humano", "Unicamper", "Capacete de Tartaruga", "Armadura de Netherite", "Espada de Dima", "Escudo", "Bota de Ferro");
        Jogador jogador2 = new Jogador("Gabriel Prado");
        Item item = new Item("Armadura de Netherite", 10, 5, "itemCorpo");
        Item item2 = new Item("Armadura", 10, 5, "itemCorpo");
        Monstro monstro = new Monstro("Creeper", 1000, 10, 100);
        Raca raca = new Raca("Pessoa pequena", "Anao", 100);
        Inventario inventario = new Inventario(1);

        // Impressão de alguns métodos para teste
        //System.out.println(jogador1);
        //System.out.println(jogador2);
        //System.out.println("Jogador1 posssui mão vazia? " + jogador1.possuiMaoVazia() + "\n");
        //System.out.println("Jogador2 posssui mão vazia? " + jogador2.possuiMaoVazia() + "\n");
        //System.out.println(item);
        //System.out.println(monstro);
        //System.out.println(raca);
        System.out.println(inventario.adicionarItem(item));
        System.out.println(inventario.adicionarItem(item2));
        System.out.println(inventario);
    }
}
