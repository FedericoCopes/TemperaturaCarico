/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temperaturacarico;

import java.util.ArrayList;

/**
 *
 * @author FEDERICOCOPES
 */
public class Veicolo {
    
    private String ID;
    private ArrayList<Misura> misure;
    
    public Veicolo(String ID, ArrayList<Misura> misure) {
        this.ID = ID;
        this.misure = misure;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Misura> getMisure() {
        return misure;
    }

    public void setMisure(ArrayList<Misura> misure) {
        this.misure = misure;
    }
}
