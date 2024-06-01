/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Player {
    private Proprieta[] proprieta= new Proprieta[10];
    private Societa[] societa= new Societa[2];
    private int numColore;
    private boolean prigione = false;
    private int saldo;
    private int ncasella;
    private boolean esciDiPrigione = false;
    private int saltaTurno;
    private int nProprieta, nSocieta;
    private Casella[] ordine = new Casella[10];
    
    public Player(int numColore, int saldo, int casella) {
        this.numColore = numColore;
        this.saldo = saldo;
        this.ncasella = casella;
    }

    public Proprieta[] getProprieta() {
        return proprieta;
    }

    public int getNumColore() {
        return numColore;
    }

    public boolean isPrigione() {
        return prigione;
    }

    public int getSaldo() {
        return saldo;
    }

    public Societa[] getSocieta() {
        return societa;
    }

    public int getnSocieta() {
        return nSocieta;
    }

    public void setnSocieta(int nSocieta) {
        this.nSocieta = nSocieta;
    }
    
    
    public void setProprieta(Proprieta proprieta) {
        this.proprieta[nProprieta] = proprieta;
    }
    
    public void setSocieta(Societa societa) {
        this.societa[nSocieta] = societa;
    }
    
    public void togliSocieta(int i){
        this.societa[i] = null;
        for(int j=i; j<societa.length; j++){
            societa[i]=societa[i+1];
        }   
    }
    
    public void setPrigione(boolean prigione) {
        this.prigione = prigione;
    }
    
    public void togliProprieta(int i){
        this.proprieta[i] = null;
        for(int j=i; j<proprieta.length; j++){
            if(i == proprieta.length)
                proprieta[i]=proprieta[i+1];
        }   
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getNcasella() {
        return ncasella;
    }

    public void setNcasella(int ncasella) {
        this.ncasella = ncasella;
    }

    public boolean isEsciDiPrigione() {
        return esciDiPrigione;
    }

    public void setEsciDiPrigione(boolean esciDiPrigione) {
        this.esciDiPrigione = esciDiPrigione;
    }

    public int getSaltaTurno() {
        return saltaTurno;
    }

    public void setSaltaTurno(int saltaTurno) {
        this.saltaTurno = saltaTurno;
    }

    public int getNproprieta(){
        return nProprieta;
    }

    public void setnProprieta(int g) {
        if(g==0)
            nProprieta++;
        if(g==1)
            nProprieta--;
    }
    
    public void setNSocieta(int g){
        if(g==0)
            nSocieta++;
        if(g==1)
            nSocieta--;
    }
    
    public int getNsocieta(){
        return nSocieta;
    }
    
    public Casella[] getOrdine(){
        return ordine;
    }
    
    public void setOrdine(Casella n) {
        this.ordine[nSocieta+nProprieta] = n;
    }
    
    public void togliOrdine(int i){
        this.ordine[i] = null;
        for(int j=i; j<societa.length+proprieta.length; j++){
            ordine[i]=ordine[i+1];
        }   
    }
}
