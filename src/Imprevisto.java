
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Imprevisto extends Casella{
   
    
 

    public Imprevisto(int numero, String nome) {
        super(numero, nome);
        
    }

   public int getNum(){
       Random random = new Random();
       int n = random.nextInt(10);
       return n;
   }
    
}
