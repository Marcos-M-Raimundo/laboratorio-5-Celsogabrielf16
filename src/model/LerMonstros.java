package model;

import app.Jogo;
import app.Monstro;
import interfaces.IArquivo;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class LerMonstros implements IArquivo{
    @Override
    public void lerArquivo(Jogo jogo, String path) {
        List<Monstro> monstros = new ArrayList<Monstro>(10);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Monstro");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element monstroElement = (Element) nodeList.item(i);

                String nome = this.getString(monstroElement, "nome");
                int poder = Integer.parseInt(this.getString(monstroElement, "poder"));
                int tesouros = Integer.parseInt(this.getString(monstroElement, "tesouros"));
                int niveisPerdidos = Integer.parseInt(this.getString(monstroElement, "niveisPerdidos"));

                Monstro Monstro = new Monstro(nome, poder, tesouros, niveisPerdidos);
                monstros.add(Monstro);
            }

        } catch (Exception exception) {
            System.err.println("Erro ao ler o aquivo de monstros: " + exception.getMessage());
            exception.printStackTrace();
        }

        jogo.getMasmorra().setMonstros(monstros);
    }

    public String getString(Element Monstro, String string) {
        return Monstro.getElementsByTagName(string).item(0).getTextContent();
    }
}
