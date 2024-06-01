/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Societa extends Casella{
    private int prezzo;
    private int tasse;
    private boolean disponibile = true;
    private int proprietario;
    
    
    public Societa( int numero, String nome, int tasse, int prezzo) {
        super(numero, nome);
        this.tasse = tasse;
        this.prezzo= prezzo;
    }
    private int ipoteca=prezzo/2;
    
    public int getTasse() {
        return tasse;
    }

    public int getIpoteca() {
        return ipoteca;
    }
    
    
    public void setTasse(int tasse) {
        this.tasse = tasse;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public int getPrezzo() {
        return prezzo;
    }
    
    
    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }
}
