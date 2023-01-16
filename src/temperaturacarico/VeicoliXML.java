/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temperaturacarico;

import java.io.*;
import java.time.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;


public class VeicoliXML {

    public static void readXMLFile(String filePath, double threshold) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(filePath);
        doc.getDocumentElement().normalize();

        NodeList veicoloList = doc.getElementsByTagName("veicolo");

        for (int i = 0; i < veicoloList.getLength(); i++) {
            Node veicoloNode = veicoloList.item(i);

            if (veicoloNode.getNodeType() == Node.ELEMENT_NODE) {
                Element veicoloElement = (Element) veicoloNode;
                String id = veicoloElement.getElementsByTagName("ID").item(0).getTextContent();
                NodeList misuraList = veicoloElement.getElementsByTagName("misura");
                boolean allBelowThreshold = true;
                List<Long> timestampAboveThreshold = new ArrayList<>();

                for (int j = 0; j < misuraList.getLength(); j++) {
                    Node misuraNode = misuraList.item(j);

                    if (misuraNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element misuraElement = (Element) misuraNode;
                        double temperature = Double.parseDouble(misuraElement.getElementsByTagName("temperatura").item(0).getTextContent());
                        String dataOra = misuraElement.getElementsByTagName("data_ora").item(0).getTextContent();

                        if (temperature > threshold) {
                            allBelowThreshold = false;
                            // Utilizzare la classe LocalDateTime o SimpleDateFormat per convertire la stringa dataOra in un oggetto Timestamp
                            LocalDateTime date = LocalDateTime.parse(dataOra);
                            long timestamp = date.toEpochSecond(ZoneOffset.UTC);
                            timestampAboveThreshold.add(timestamp);
                        }
                    }
                }

                System.out.println("Il veicolo con ID: " + id + " ha tutte le temperature sotto la soglia? : " + allBelowThreshold);
                if (!allBelowThreshold) {
                    System.out.println("Timestamp in cui la temperatura e' superiore al valore di soglia : " + timestampAboveThreshold);
                }
            }
        }
    }
}
