/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temperaturacarico;

/**
 *
 * @author FEDERICOCOPES
 */
public class Misura {
    private double temperatura;
    private long dataOra;
    
    public Misura(double temperatura, long data) {
        this.temperatura = temperatura;
        this.dataOra = data;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public long getDataOra() {
        return dataOra;
    }

    public void setDataOra(long data) {
        this.dataOra = data;
    }
}
