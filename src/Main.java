public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Celso", 16, "Humano", "Unicamper", "Capacete de Tartaruga", "Armadura de Netherite", "Espada de Dima", "Escudo", "Bota de Ferro");
        Jogador jogador2 = new Jogador("Gabriel Prado");
        Item item = new Item();
        Monstro monstro = new Monstro();

        System.out.println(jogador1.toString());
        System.out.println(jogador2.toString());
    }
}