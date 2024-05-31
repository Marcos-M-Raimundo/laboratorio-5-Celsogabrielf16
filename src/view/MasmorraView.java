package view;

import java.util.Scanner;

public class MasmorraView {

    public void exibirMensagem(String mensagem) {
        System.out.print(mensagem);
    }

    public String recebeString(Scanner scanner) {
        return scanner.nextLine();
    }
}
