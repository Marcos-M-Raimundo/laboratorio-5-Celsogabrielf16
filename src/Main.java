public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Celso", 16, "Humano", "Unicamper", "Capacete de Tartaruga", "Armadura de Netherite", "Espada de Dima", "Escudo", "Bota de Ferro");
        Jogador jogador2 = new Jogador("Gabriel Prado");

        Item item = new Item("Armadura de Netherite", 10, 5, "itemCorpo");

        Monstro monstro = new Monstro("Creeper", 1000, 10, 100);

        System.out.println(jogador1.toString());
        System.out.println(jogador2.toString());
        System.out.println("Jogador1 posssui mão vazia? " + jogador1.possuiMaoVazia() + "\n"); // False
        System.out.println("Jogador2 posssui mão vazia? " + jogador2.possuiMaoVazia() + "\n"); // True

        System.out.println(item.toString());

        System.out.println(monstro.toString());
    }
}