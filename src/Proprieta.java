/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Proprieta extends Casella{
    
    private int costoAcquisto;
    private int costoCasa;
    private int pzIpoteca;
    private int gruppo;
    private int tassa;
    private boolean disponibile;
    private int nCase;
    private int proprietario;
    private int tassaBase;
    public Proprieta(int numero, String nome, int costoAcquisto, int costoCasa, int pzIpoteca, int gruppo, int tassa, boolean disponibile, int nCase) {
        super(numero, nome);
        this.costoAcquisto = costoAcquisto;
        this.costoCasa = costoCasa;
        this.pzIpoteca = pzIpoteca;
        this.gruppo = gruppo;
        this.tassa = tassa;
        this.disponibile = disponibile;
        this.nCase = nCase;
        this.tassaBase =tassa;
    }

    public int getCostoAcquisto() {
        return costoAcquisto;
    }

    public int getTassaBase() {
        return tassaBase;
    }
    
    
    public int getCostoCasa() {
        return costoCasa;
    }

    public int getPzIpoteca() {
        return pzIpoteca;
    }

    public int getGruppo() {
        return gruppo;
    }

    public int getTassa() {
        return tassa;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public void setTassa(int tassa) {
        this.tassa = tassa;
    }

    public void setnCase() {
        this.nCase ++;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public int getnCase() {
        return nCase;
    }

  
    
    
}
