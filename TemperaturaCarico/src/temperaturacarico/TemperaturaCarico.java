/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperaturacarico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author FEDERICOCOPES
 */
public class TemperaturaCarico {

    /**
     * @param args the command line arguments
     */
    private final List<Veicolo> veicoli;

    public TemperaturaCarico() {
        veicoli = new ArrayList<Veicolo>();
    }
    
    public List<Veicolo> parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        // creazione dell'albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "posizione"
        nodelist = root.getElementsByTagName("posizione");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i); //accedo al singolo elemento della nodeList
               // veicoli.add(getPosizione(element));
            }
        }
        return veicoli;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        List<Veicolo> veicoli = null;
        TemperaturaCarico parser = new TemperaturaCarico();
        try {
            veicoli = parser.parseDocument(args[0]);
        } catch (ParserConfigurationException | SAXException exception) {
            System.err.println("Errore parsing file XML");
        } catch (IOException exception) {
            System.err.println("Errore apertura file XML/XSD");
        }
        for(Veicolo v : veicoli)
            System.out.println(v);
    }
    
}
