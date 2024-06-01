/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Via extends Casella{
   
    private int aumentasaldo;
    
    public Via(int numero, String nome, int aumentasaldo) {
        super(numero, nome);
        this.aumentasaldo = aumentasaldo;
    }
    
    public int getAumentaSaldo(){
        return aumentasaldo;
    }
    
}
