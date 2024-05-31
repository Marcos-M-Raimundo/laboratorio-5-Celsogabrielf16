package model;

import controller.JogadorController;
import app.Classe;
import app.Jogo;
import app.Raca;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import interfaces.IArquivo;
import view.JogadorView;

import org.w3c.dom.Element;

public class LerJogadores implements IArquivo {
    @Override
    public void lerArquivo(Jogo jogo, String path) {
        List<JogadorController> jogadores = new ArrayList<JogadorController>(6);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Jogador");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element jogadorElement = (Element) nodeList.item(i);

                String nome = this.getString(jogadorElement, "nome");
                int nivel = Integer.parseInt(this.getString(jogadorElement, "nivel"));
                Raca raca = Raca.valueOf(this.getString(jogadorElement, "raca"));
                Classe classe = Classe.valueOf(this.getString(jogadorElement, "classe"));

                JogadorController jogador = new JogadorController(new JogadorView(), new Jogador(nome, nivel, raca, classe));
                jogadores.add(jogador);
            }

        } catch (Exception exception) {
            System.err.println("Erro ao ler o aquivo de jogadores: " + exception.getMessage());
            exception.printStackTrace();
        }

        jogo.setJogadores(jogadores);
    }

    private String getString(Element element, String string) {
        return element.getElementsByTagName(string).item(0).getTextContent();
    }
}
