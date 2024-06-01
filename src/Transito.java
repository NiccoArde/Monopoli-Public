/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Transito extends Casella{
    private boolean prigione = false;
    private int giri;

    public Transito( int numero, String nome) {
        super(numero, nome);
    }

    public boolean isPrigione() {
        return prigione;
    }

    public int getGiri() {
        return giri;
    }

    public void setGiri(int giri) {
        this.giri = giri;
    }
    

    public void setPrigione(boolean prigione) {
        this.prigione = prigione;
    }

    
    
   
   
}
    
