/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperaturacarico;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author FEDERICOCOPES
 */
public class TemperaturaCarico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Scanner input = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.print("Inserire il valore di soglia con cui si vogliono confrontare le misure rilevate: ");
        double soglia = input.nextDouble();
        try {
            parser.readXMLFile(args[0], soglia);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Errore durante il parsing del file XML: " + e.getMessage());
        }
    }
    
}