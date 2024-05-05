import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LerTesouros  implements I_Arquivo {
    @Override
    public void lerArquivo(Jogo jogo, String path) {
        BauDeTesouros bauDeTesouros = new BauDeTesouros(20);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element itemElement = (Element) nodeList.item(i);

                String nome = this.getString(itemElement, "nome");
                int bonusPoder = Integer.parseInt(this.getString(itemElement, "bonusPoder"));
                int valor = Integer.parseInt(this.getString(itemElement, "valor"));
                TipoItem tipo = TipoItem.valueOf(this.getString(itemElement, "tipo"));
                boolean itemGrande = Boolean.parseBoolean(this.getString(itemElement, "itemGrande"));

                List<Classe> classesCompativeis = new ArrayList<Classe>(5);
                NodeList nodeListClassesCompativeis = itemElement.getElementsByTagName("classesCompativeis");
                for (int indiceClasse = 0; indiceClasse < nodeListClassesCompativeis.getLength(); indiceClasse++) {
                    Element classeElement = (Element) nodeListClassesCompativeis.item(indiceClasse);
                    Classe classe = Classe.valueOf(this.getString(classeElement, "classe"));
                    classesCompativeis.add(classe);
                }

                List<Raca> racasCompativeis = new ArrayList<Raca>(5);
                NodeList nodeListRacasCompativeis = itemElement.getElementsByTagName("racasCompativeis");
                for (int indiceClasse = 0; indiceClasse < nodeListRacasCompativeis.getLength(); indiceClasse++) {
                    Element classeElement = (Element) nodeListRacasCompativeis.item(indiceClasse);
                    Raca raca = Raca.valueOf(this.getString(classeElement, "raca"));
                    racasCompativeis.add(raca);
                }

                Item item = new Item(nome, bonusPoder, valor, tipo, itemGrande, classesCompativeis, racasCompativeis);
                bauDeTesouros.adicionarItem(item);
            }

        } catch (Exception exception) {
            System.err.println("Erro ao ler o aquivo de tesouros: " + exception.getMessage());
            exception.printStackTrace();
        }

        jogo.getMasmorra().setTesouros(bauDeTesouros);
    }

    public String getString(Element element, String string) {
        return element.getElementsByTagName(string).item(0).getTextContent();
    }
}
