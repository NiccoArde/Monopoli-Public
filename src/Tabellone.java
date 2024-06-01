
import com.sun.source.tree.CaseLabelTree;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Tabellone extends javax.swing.JFrame {

    /**
     * Creates new form Names
     */
    
    public Tabellone() {
        initComponents();
        Setting.setVisible(false);
        Line.setVisible(true);
        Possibilità.setVisible(false);
        Tabellone.setVisible(false);
        Case.setVisible(false);
        ImpProb.setVisible(false);
        IpotecaPr.setVisible(false);
        Imprevisti.setVisible(false);
        Proprieta.setVisible(false);
        Compra.setVisible(false);
        Costruisci.setVisible(false);
        Ipoteca.setVisible(false);
        PagaETermina.setVisible(false);
        Conferma.setVisible(false);
        EsciDiPrigione.setVisible(false);
        PartitaFinita.setVisible(false);
        ImageIcon icon = new ImageIcon("nave.png");
        Turno.setIcon(icon);
        PartitaTerminata.setVisible(false);
    }
    
    
    
 /*   
--.        ,--.                                 
|  | ,---.,-'  '-. ,--,--.,--,--, ,-----. ,---.  
|  |(  .-''-.  .-'' ,-.  ||      \`-.  / | .-. : 
|  |.-'  `) |  |  \ '-'  ||  ||  | /  `-.\   --. 
`--'`----'  `--'   `--`--'`--''--'`-----' `----' 
  */
   int nPlayer;
    int currentPlayer=1;
    int casellaCorrente = 0;
    int nDadi;
    int[] numPrecedente = null;
    int tot1 = 0, tot2=0, tot3=0, tot4=0, tot;
    private Player player1, player2, player3, player4, playerCorrente ;
    private Casella[] caselle = new Casella[32];
    private int flagImp=0;
    String nome1, nome2, nome3 ,nome4, maxPatrimonio;
    private boolean possibilita = true;
    int flagDadi = 0;
    public Clip clip;
    
    
    
    
    
    public void istanziaPlayer(int num){
        ImageIcon iconaAuto = new ImageIcon("auto.png");
        ImageIcon iconaCane = new ImageIcon("cane.png");
        ImageIcon iconaNave = new ImageIcon("nave.png");
        ImageIcon iconaCappello = new ImageIcon("cappello.png");
        P1.setIcon(iconaNave);
        P2.setIcon(iconaCane);
        
             player1 = new Player(1, 10000,0);
             player2 = new Player(2, 10000,0);
        if(num==3){
             player3 = new Player(3, 10000,0);
             P3.setIcon(iconaCappello);
        }if(num==4){
             player3 = new Player(3, 10000,0);
             player4 = new Player(4, 10000, 0);
             P3.setIcon(iconaCappello);
             P4.setIcon(iconaAuto);
        }
        nPlayer=num;
        playerCorrente= player1;
        istanziaCaselle();
        aggiornaSaldo();
    }
    
    public void istanziaCaselle(){
        caselle[0] = new Via(0, "VIA", 2000);
        caselle[1] = new Proprieta(1, "Taranto", 600, 120, 300, 1, 60, true, 0);
        caselle[2] = new Imprevisto(2,"Probabilità");
        caselle[3] = new Proprieta(3, "Trieste", 600, 120, 300, 1, 60, true, 0);
        caselle[4] = new Tassa(4, "Tassa patrimoniale", 1500);
        caselle[5] = new Proprieta(5, "Padova", 1000, 200, 500, 2, 100, true, 0);
        caselle[6] = new Imprevisto(6,"Imprevisto");
        caselle[7] = new Proprieta(7, "Messina", 1000, 200, 500, 2, 100, true, 0);
        caselle[8] = new Transito(8, "transito");
        caselle[9] = new Proprieta(9, "Verona", 1400, 280, 700, 3, 140, true, 0);
        caselle[10] = new Proprieta(10, "Venezia", 1400, 280, 700, 3, 140, true, 0);
        caselle[11] = new Imprevisto(11,"Imprevisto");
        caselle[12] = new Societa(12, "Società elettrica", 150, 1500);
        caselle[13] = new Proprieta(13, "Catania", 1800, 360, 900, 4, 180, true, 0);
        caselle[14] = new Imprevisto(14, "Probabilità");
        caselle[15] = new Proprieta(15, "Bari", 1800, 360, 900, 4, 180, true, 0);
        caselle[16] = new Parcheggio(16, "Parcheggio");
        caselle[17] = new Proprieta(17, "Firenze", 2200, 440, 1100, 5, 220, true, 0);
        caselle[18] = new Proprieta(18, "Bologna", 2200, 440, 1100, 5, 220, true, 0);
        caselle[19] = new Imprevisto(2,"Imprevisto");
        caselle[20] = new Proprieta(20, "Genova", 2600, 520, 1300, 6, 260, true, 0);
        caselle[21] = new Societa(21, "Società idrica", 150, 1500);
        caselle[22] = new Proprieta(22, "Palermo", 2600, 520, 1300, 6, 260, true, 0);
        caselle[23] = new Imprevisto(23, "Probabilità");
        caselle[24] = new Prigione(24, "Prigione");
        caselle[25] = new Proprieta(25, "Torino", 3000, 600, 1500, 7, 300, true, 0);
        caselle[26] = new Imprevisto(26,"Probabilità");
        caselle[27] = new Proprieta(27, "Napoli", 3000, 600, 1500, 7, 300, true, 0);
        caselle[28] = new Tassa(28, "Tassa di Lusso", 1500);
        caselle[29] = new Proprieta(29, "Milano", 3500, 600, 1750, 8, 350, true, 0);
        caselle[30] = new Imprevisto(30,"Imprevisto");
        caselle[31] = new Proprieta(31, "Roma", 3500, 600, 1750, 8, 350, true, 0);
        
    }   
    
     /*
                                              
,--.   ,--.               ,--.               
|   `.'   |,--.,--. ,---. `--' ,---. ,--,--. 
|  |'.'|  ||  ||  |(  .-' ,--.| .--'' ,-.  | 
|  |   |  |'  ''  '.-'  `)|  |\ `--.\ '-'  | 
`--'   `--' `----' `----' `--' `---' `--`--' 
                                             
                                                                       
    */
    public void canzonebase() {
        try {
            String filePath = "moseca.wav";
            File audioFile = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

            // Leggi i dati audio in un buffer di byte
            byte[] audioData = new byte[(int) audioFile.length()];
            ais.read(audioData);

            // Crea un ByteArrayInputStream dal buffer di byte
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, ais.getFormat(), audioData.length);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException e) {
            System.err.println("Formato audio non supportato.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Errore di I/O durante il caricamento del file audio.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("Linea audio non disponibile.");
            e.printStackTrace();
        }
    }

    public void stopSong() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        } else {
            System.out.println("La canzone non è in esecuzione o il clip non è inizializzato.");
        }
    }
    
    
    
    /*
                                                                        
,--------.,--.                            ,------.             ,--.,--. 
'--.  .--'`--',--,--,--. ,---. ,--.--.    |  .-.  \  ,--,--. ,-|  |`--' 
   |  |   ,--.|        || .-. :|  .--'    |  |  \  :' ,-.  |' .-. |,--. 
   |  |   |  ||  |  |  |\   --.|  |       |  '--'  /\ '-'  |\ `-' ||  | 
   `--'   `--'`--`--`--' `----'`--'       `-------'  `--`--' `---' `--' 
                                                                        
    */
    
    private Timer timer;

// Avvia il timer per cambiare le immagini dei dadi dopo un certo periodo di tempo
    

    // Funzione per cambiare l'immagine dei dadi
    private void changeLabelImage(int d1, int d2) {
        // Assicurati che le immagini siano presenti nel percorso specificato
        ImageIcon icon = new ImageIcon("Dado" + d1 + ".png");
        ImageIcon icon2 = new ImageIcon("Dado" + d2 + ".png");
        LabelDadi1.setIcon(icon);
        LabelDadi2.setIcon(icon2);
        
    }

    // Inizializza il timer per cambiare l'immagine dei dadi dopo un certo periodo di tempo
    private void initTimer(int d1, int d2, int n) {
        
        timer = new Timer(n, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLabelImage(d1, d2); // Cambia l'immagine dei dadi
            }
        });
        timer.setRepeats(false); // Imposta il timer per non ripetersi
    }

    // Funzione per avviare il timer per cambiare l'immagine dei dadi
    private void startTimer(int d1, int d2, int n) {
        initTimer(d1, d2, n); // Inizializza il timer per i dadi
        timer.start(); // Avvia il timer
        Dadi.setVisible(false);
    }

    
    
    /*
                                                                                           
,--------.,--.                             ,-----.                      ,--.,--.        
'--.  .--'`--',--,--,--. ,---. ,--.--.    '  .--./ ,--,--. ,---.  ,---. |  ||  | ,---.  
   |  |   ,--.|        || .-. :|  .--'    |  |    ' ,-.  |(  .-' | .-. :|  ||  || .-. : 
   |  |   |  ||  |  |  |\   --.|  |       '  '--'\\ '-'  |.-'  `)\   --.|  ||  |\   --. 
   `--'   `--'`--`--`--' `----'`--'        `-----' `--`--'`----'  `----'`--'`--' `----' 
                                                                                        
    */
    private Timer timer2;

// Avvia il timer per cambiare le immagini dei dadi dopo un certo periodo di tempo
    


    // Inizializza il timer per cambiare l'immagine dei dadi dopo un certo periodo di tempo
    private void initTimer2(int d ,Player player, int n, int[] num) {
        
        timer2 = new Timer(n, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muoviPedina(d, player, num);   
            }
        });
        timer2.setRepeats(false); // Imposta il timer per non ripetersi
    }

    // Funzione per avviare il timer per cambiare l'immagine dei dadi
    private void startTimer2(int d, Player player, int n, int[] num) {
        initTimer2(d,player, n, num); // Inizializza il timer per i dadi
        timer2.start(); // Avvia il timer
        Dadi.setVisible(false);
    }
    
    
    
    
    /*
                                                                                                 
,--------.,--.                            ,--.                ,--.                           
'--.  .--'`--',--,--,--. ,---. ,--.--.    |  | ,---.  ,---. ,-'  '-. ,---.  ,---. ,--,--.    
   |  |   ,--.|        || .-. :|  .--'    |  || .-. || .-. |'-.  .-'| .-. :| .--'' ,-.  |    
   |  |   |  ||  |  |  |\   --.|  |       |  || '-' '' '-' '  |  |  \   --.\ `--.\ '-'  |    
   `--'   `--'`--`--`--' `----'`--'       `--'|  |-'  `---'   `--'   `----' `---' `--`--'    
                                              `--'                                         
    */
    
    // Inizializza il timer per cambiare l'immagine dei dadi dopo un certo periodo di tempo
    private void initTimerIpoteca(int n, Player player) {
        
        timer2 = new Timer(n, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IpotecaPr.setVisible(true);
                IpotecaProprieta(player);
                Proprieta.setVisible(false);  
            }
        });
        timer2.setRepeats(false); // Imposta il timer per non ripetersi
    }

    // Funzione per avviare il timer per cambiare l'immagine dei dadi
    private void startTimerIpoteca(int n, Player player) {
        initTimerIpoteca(n, player); // Inizializza il timer per i dadi
        timer2.start(); // Avvia il timer
        Dadi.setVisible(false);
    }
    
    
    /*
                                               
,------.           ,--.,--.                 
|  .--. ' ,---.  ,-|  |`--',--,--,   ,--,--. 
|  '--' || .-. :' .-. |,--.|      \ ' ,-.  | 
|  | --' \   --.\ `-' ||  ||  ||  | \ '-'  | 
`--'      `----' `---' `--'`--''--'  `--`--' 
    */
   public void muoviPedina(int n, Player player, int[] precedenti){
      int flag= 0;
      /*for(int i=0; i<precedenti.length;i++){
          for(int j=1; j<precedenti.length; j++){
            if(precedenti[j]==precedenti[i]){
                flag=1;
            }
        }
      }*/
      
      if(flag==0){
        switch (player.getNcasella()) {
         case 0:
             Pedina0.setIcon(null);
             break;
         case 1:
             Pedina1.setIcon(null);
             break;
         case 2:
             Pedina2.setIcon(null);
             break;
         case 3:
             Pedina3.setIcon(null);
             break;
         case 4:
             Pedina4.setIcon(null);
             break;
         case 5:
             Pedina5.setIcon(null);
             break;
         case 6:
             Pedina6.setIcon(null);
             break;
         case 7:
             Pedina7.setIcon(null);
             break;
         case 8:
             Pedina8.setIcon(null);
             break;
         case 9:
             Pedina9.setIcon(null);
             break;
         case 10:
             Pedina10.setIcon(null);
             break;
         case 11:
             Pedina11.setIcon(null);
             break;
         case 12:
             Pedina12.setIcon(null);
             break;
         case 13:
             Pedina13.setIcon(null);
             break;
         case 14:
             Pedina14.setIcon(null);
             break;
         case 15:
             Pedina15.setIcon(null);
             break;
         case 16:
             Pedina16.setIcon(null);
             break;
         case 17:
             Pedina17.setIcon(null);
             break;
         case 18:
             Pedina18.setIcon(null);
             break;
         case 19:
             Pedina19.setIcon(null);
             break;
         case 20:
             Pedina20.setIcon(null);
             break;
         case 21:
             Pedina21.setIcon(null);
             break;
         case 22:
             Pedina22.setIcon(null);
             break;
         case 23:
             Pedina23.setIcon(null);
             break;
         case 24:
             Pedina24.setIcon(null);
             break;
         case 25:
             Pedina25.setIcon(null);
             break;
         case 26:
             Pedina26.setIcon(null);
             break;
         case 27:
             Pedina27.setIcon(null);
             break;
         case 28:
             Pedina28.setIcon(null);
             break;
         case 29:
             Pedina29.setIcon(null);
             break;
         case 30:
             Pedina30.setIcon(null);
             break;
         case 31:
             Pedina31.setIcon(null);
             break;
     }
      }
       ImageIcon icon = null;
       System.out.println(player.getNcasella());
       if(player.getSaltaTurno()>0 && player.getNcasella()!=8){
           player.setSaltaTurno(player.getSaltaTurno()-1);
           cambiaGiocatore(currentPlayer);
            
       }else if(player.getSaltaTurno()>0 && player.getNcasella()==8){
           if(player.isEsciDiPrigione()== true){
               Proprieta.setVisible(false);
               ImmProp.setVisible(false);
                EsciDiPrigione.setVisible(true);
                if(player==player1)
                    jLabel9.setText(nome1);
                if(player==player2)
                    jLabel9.setText(nome2);
                if(player==player3)
                    jLabel9.setText(nome3);
                if(player==player4)
                    jLabel9.setText(nome4);
           }else{
               player.setSaltaTurno(player.getSaltaTurno()-1);
               cambiaGiocatore(currentPlayer);
           }  
       }else{
            if ((player.getNcasella()+n) >31){
                int num = 31-player.getNcasella();
                player.setNcasella(n-num);
                int numero = 31-casellaCorrente; 
                casellaCorrente = n-numero;
                player.setSaldo(player.getSaldo()+2000);
                aggiornaSaldo();
            }else{
                player.setNcasella(player.getNcasella()+n);
                casellaCorrente+=n;
            }

            System.out.println(player.getNcasella());
            eseguiFunzioni(player);
       }
        if(player.getNumColore() == 1)   
            icon = new ImageIcon("nave.png");
        if(player.getNumColore() == 2)   
            icon = new ImageIcon("cane.png");
        if(player.getNumColore() == 3)   
            icon = new ImageIcon("cappello.png");
        if(player.getNumColore() == 4)   
            icon = new ImageIcon("auto.png");
        
        switch(player.getNcasella()){
             case 0:
                Pedina0.setIcon(icon);
                break;
            case 1:
                Pedina1.setIcon(icon);
                break;
            case 2:
                Pedina2.setIcon(icon);
                break;
            case 3:
                Pedina3.setIcon(icon);
                break;
            case 4:
                Pedina4.setIcon(icon);
                break;
            case 5:
                Pedina5.setIcon(icon);
                break;
            case 6:
                Pedina6.setIcon(icon);
                break;
            case 7:
                Pedina7.setIcon(icon);
                break;
            case 8:
                Pedina8.setIcon(icon);
                break;
            case 9:
                Pedina9.setIcon(icon);
                break;
            case 10:
                Pedina10.setIcon(icon);
                break;
            case 11:
                Pedina11.setIcon(icon);
                break;
            case 12:
                Pedina12.setIcon(icon);
                break;
            case 13:
                Pedina13.setIcon(icon);
                break;
            case 14:
                Pedina14.setIcon(icon);
                break;
            case 15:
                Pedina15.setIcon(icon);
                break;
            case 16:
                Pedina16.setIcon(icon);
                break;
            case 17:
                Pedina17.setIcon(icon);
                break;
            case 18:
                Pedina18.setIcon(icon);
                break;
            case 19:
                Pedina19.setIcon(icon);
                break;
            case 20:
                Pedina20.setIcon(icon);
                break;
            case 21:
                Pedina21.setIcon(icon);
                break;
            case 22:
                Pedina22.setIcon(icon);
                break;
            case 23:
                Pedina23.setIcon(icon);
                break;
            case 24:
                Pedina24.setIcon(icon);
                break;
            case 25:
                Pedina25.setIcon(icon);
                break;
            case 26:
                Pedina26.setIcon(icon);
                break;
            case 27:
                Pedina27.setIcon(icon);
                break;
            case 28:
                Pedina28.setIcon(icon);
                break;
            case 29:
                Pedina29.setIcon(icon);
                break;
            case 30:
                Pedina30.setIcon(icon);
                break;
            case 31:
                Pedina31.setIcon(icon);
                break;
        }
    }
   
   /*
                                               
,------.                          ,--.  ,--. 
|  .---',--.  ,--.,---. ,--,--, ,-'  '-.`--' 
|  `--,  \  `'  /| .-. :|      \'-.  .-',--. 
|  `---.  \    / \   --.|  ||  |  |  |  |  | 
`------'   `--'   `----'`--''--'  `--'  `--' 
                                             
   */
   
   public void eseguiFunzioni(Player player){
       int flag=0;
       if(player.getSaltaTurno()==0){
            if(player.getNcasella()==6 || player.getNcasella()==11 || player.getNcasella()==19 || player.getNcasella()==26){
                 Imprevisti(player, player.getNcasella());
                 flag=1;
            }else if(player.getNcasella()==2 || player.getNcasella()==14 || player.getNcasella()==23 || player.getNcasella()==30){
                 Probabilita(player, player.getNcasella());
                 flag=1;
            }else if(player.getNcasella() == 0){
                Compra.setVisible(false);
            }else if(player.getNcasella() == 8){
                jLabel7.setText("aspetta qui il tuo prossimo turno");
                jLabel6.setVisible(false);
                jLabel8.setVisible(false);
                Compra.setVisible(false);
            }else if(player.getNcasella() == 24){
                player.setPrigione(true);
                player.setSaltaTurno(2);
                player.setNcasella(8);
                Compra.setVisible(false);
            } else if(player.getNcasella() == 4 || player.getNcasella() == 28){
                controllaPossibilita(player, 1500);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-1500));
               
                jLabel6.setText("1500 M");
                jLabel8.setText("paga");
                Compra.setVisible(false);
                Ipoteca.setVisible(false);
                Costruisci.setVisible(false);
                PagaETermina.setVisible(false);
                TerminaTurno.setVisible(true);
                jLabel7.setVisible(false);
            } else if(player.getNcasella() == 12 || player.getNcasella() == 21){
                mostraProprieta(player.getNcasella());
            }else if(player.getNcasella() == 16){
                jLabel7.setText("aspetta qui il tuo prossimo turno");
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
                Compra.setVisible(false);Compra.setVisible(false);
                Ipoteca.setVisible(false);
                Costruisci.setVisible(false);
                PagaETermina.setVisible(false);
                TerminaTurno.setVisible(true);
                    
            }else{
                mostraProprieta(player.getNcasella());
            }
            if(flag==0){
            
                Proprieta.setVisible(true);
                Citta.setText("sei arrivato a " + caselle[player.getNcasella()].getNome());
                System.out.println("sei arrivato a " + caselle[player.getNcasella()].getNome());
                ImageIcon imm = new ImageIcon(caselle[player.getNcasella()].getNome() + ".png");
                ImmProp.setIcon(imm);
                if(player.isPrigione() &&  player.getNcasella()==8){
                    Citta.setText("sei arrivato a " + "Prigione");
                    imm = new ImageIcon("Prigione.png");
                    ImmProp.setIcon(imm);
                    jLabel6.setVisible(false);
                    jLabel8.setVisible(false);
                    jLabel7.setText("salta due turni");
                     PagaETermina.setVisible(false);
                     TerminaTurno.setVisible(true);
                }
            }
        } else{
           player.setSaltaTurno(player.getSaltaTurno()-1);
           flagDadi=2;
           if(player.getSaltaTurno()==0){
               player.setPrigione(false);
               System.out.println("" + player.isPrigione());
           }
       }
       
   }
   
   
   public void mostraProprieta(int n){
        
        jLabel6.setVisible(true);
        jLabel8.setVisible(true);
       if (caselle[n] instanceof Proprieta) {
        Proprieta proprietaSelezionata = (Proprieta) caselle[n];
            if (proprietaSelezionata.isDisponibile()) {
                TerminaTurno.setVisible(true);
                Compra.setVisible(true);
                PagaETermina.setVisible(false);
                Ipoteca.setVisible(false);
                Costruisci.setVisible(false);
                jLabel8.setText("compra per:");
                jLabel7.setText("disponibile");
                jLabel6.setText("" + proprietaSelezionata.getCostoAcquisto()+ " M");
            }else{
                if(currentPlayer != proprietaSelezionata.getProprietario()){
                    Ipoteca.setVisible(false);
                    PagaETermina.setVisible(true);
                    TerminaTurno.setVisible(false);
                    String nome = null;
                    if(proprietaSelezionata.getProprietario()==1)
                         nome = nome1;
                    if(proprietaSelezionata.getProprietario()==2)
                         nome = nome2;
                    if(proprietaSelezionata.getProprietario()==3)
                         nome = nome3;
                    if(proprietaSelezionata.getProprietario()==4)
                        nome = nome4;
                    jLabel8.setText("Paga a " + nome);
                    jLabel7.setText("non disponibile");
                    jLabel6.setText(""+proprietaSelezionata.getTassa());
                    Compra.setVisible(false);
                }if(currentPlayer == proprietaSelezionata.getProprietario()){
                        PagaETermina.setVisible(false);
                        jLabel7.setText(" la proprietà e' tua");
                        jLabel6.setVisible(false);
                        jLabel8.setVisible(false);
                        Ipoteca.setVisible(true);
                        Compra.setVisible(false);
                        TerminaTurno.setVisible(true);
                        Player giocatoreCorrente = null;
                        if(currentPlayer==1)
                                giocatoreCorrente = player1;
                        if(currentPlayer==2)
                                giocatoreCorrente = player2;
                        if(currentPlayer==3)
                                giocatoreCorrente = player3;
                        if(currentPlayer==4)
                                giocatoreCorrente = player4;
                        if (haDueProprietaStessoGruppo(giocatoreCorrente, proprietaSelezionata.getGruppo())) {
                            // Se il giocatore possiede due proprietà dello stesso gruppo, mostra il pulsante "costruisci casa"jLabel8.setText("costruisci casa per");
                            jLabel6.setText(proprietaSelezionata.getCostoCasa()+ " M"); 
                            Costruisci.setVisible(true);
                            jLabel8.setText("costruisci casa per:");
                            jLabel6.setText(""+proprietaSelezionata.getCostoCasa());
                        }
                }
            }
            Citta.setText("sei arrivato a " + caselle[n].getNome());
        }
       if(caselle[n] instanceof Societa){
           Societa societaSelezionata = (Societa) caselle[n];
            if (societaSelezionata.isDisponibile()) {
                Compra.setVisible(true);
                Costruisci.setVisible(false);
                Ipoteca.setVisible(false);
                TerminaTurno.setVisible(true);
                PagaETermina.setVisible(false);
                jLabel8.setText("compra per:");
                jLabel7.setText("disponibile");
                jLabel6.setText("" + societaSelezionata.getPrezzo()+ " M");
            }else{
                if(currentPlayer != societaSelezionata.getProprietario()){
                    Ipoteca.setVisible(false);
                    PagaETermina.setVisible(true);
                    TerminaTurno.setVisible(false);
                    String nome = null;
                    if(societaSelezionata.getProprietario()==1)
                         nome = nome1;
                    if(societaSelezionata.getProprietario()==2)
                         nome = nome2;
                    if(societaSelezionata.getProprietario()==3)
                         nome = nome3;
                    if(societaSelezionata.getProprietario()==4)
                        nome = nome4;
                    jLabel7.setText("non disponibile");
                    jLabel6.setText(""+societaSelezionata.getTasse());
                    Compra.setVisible(false);
                }if(currentPlayer == societaSelezionata.getProprietario()){
                        PagaETermina.setVisible(false);
                        jLabel7.setText(" la società e' tua");
                        jLabel6.setVisible(false);
                        jLabel8.setVisible(false);
                        Ipoteca.setVisible(true);
                        Compra.setVisible(false);
                        TerminaTurno.setVisible(true);
                
                }
            }
            Citta.setText("sei arrivato a " + caselle[n].getNome());
        }
       
   }
   
   
   private boolean haDueProprietaStessoGruppo(Player giocatore, int gruppo) {
        Proprieta[] proprietaGiocatore = giocatore.getProprieta();
        int contatore = 0;
        for (Proprieta p : proprietaGiocatore) {
            if (p != null && p.getGruppo() == gruppo) {
                contatore++;
            }
        }
        return contatore >= 2;
    }
   
   
   public void Imprevisti(Player player, int casella){
        Random random = new Random();
        int n = random.nextInt(10)+1;
        Proprieta.setVisible(false);
        ImpProb.setVisible(true);
        ImageIcon icon = new ImageIcon("Imprevisto"+n+".png");
        jLabel3.setIcon(icon);
        switch (n) {
            case 1:
                player.setNcasella(casella-3);
                mostraProprieta(player.getNcasella());
            break;
            case 2:
                player.setNcasella(8);
                player.setPrigione(true);
                player.setSaltaTurno(2);
            break;
            case 3:
                controllaPossibilita(player, 500);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-500));
            break;
            case 4:
                player.setNcasella(31);
            break;
            case 5:
                if(currentPlayer==1){
                    player2.setSaldo(player2.getSaldo()-200);
                    if(nPlayer==3)
                        player3.setSaldo(player3.getSaldo()-200);
                    if(nPlayer==4){
                        player3.setSaldo(player3.getSaldo()-200);
                        player4.setSaldo(player4.getSaldo()-200);
                    }
                }if(currentPlayer==2){
                    player1.setSaldo(player1.getSaldo()-200);
                    if(nPlayer==3)
                        player3.setSaldo(player3.getSaldo()-200);
                    if(nPlayer==4){
                        player3.setSaldo(player3.getSaldo()-200);
                        player4.setSaldo(player4.getSaldo()-200);
                    }
                }if(currentPlayer==3){
                    if(nPlayer==3){
                        player1.setSaldo(player1.getSaldo()-200);
                        player2.setSaldo(player2.getSaldo()-200);
                    }if(nPlayer==4){
                        player1.setSaldo(player1.getSaldo()-200);
                        player2.setSaldo(player2.getSaldo()-200);
                        player4.setSaldo(player4.getSaldo()-200);
                    } 
                }if(currentPlayer==4){
                    player2.setSaldo(player2.getSaldo()-200);
                    player1.setSaldo(player1.getSaldo()-200);
                    player3.setSaldo(player3.getSaldo()-200);  
                }
                player.setSaldo(player.getSaldo()+((nPlayer-1)*200));
            break;
            case 6:
                controllaPossibilita(player, 400);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-400));
            break;
            case 7:
                player.setNcasella(0);
                player.setSaldo(player.getSaldo()+2000);
            break;
            case 8:
                controllaPossibilita(player, 200);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-200));
            break;
            case 9:
                player.setSaldo((player.getSaldo()+1500));
            break;
            case 10:
                controllaPossibilita(player, 300);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-300));
            break;
            
        default:
               throw new AssertionError();
       }
        
   }
   
   
   public void Probabilita(Player player, int casella){
        Random random = new Random();
        Proprieta.setVisible(false);
        EsciDiPrigione.setVisible(false);
        int n = random.nextInt(10)+1;
        ImpProb.setVisible(true);
        ImageIcon icon = new ImageIcon("Probabilita"+n+".png");
        jLabel3.setIcon(icon);
        switch (n) {
            case 1:
                Dadi.setVisible(true);
                flagDadi=1;
                OkImpProb.setEnabled(false);
            break;
            case 2:
                player.setSaldo(player.getSaldo()+500);
            break;
            case 3:
                controllaPossibilita(player, 700);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-700));
            break;
            case 4:
               if(player.getNcasella()>20)
                   player.setSaldo(player.getSaldo()+2000);
               player.setNcasella(20);
                mostraProprieta(player.getNcasella());
            break;
            case 5:
                if(currentPlayer==1){
                    player2.setSaldo(player2.getSaldo()+200);
                    if(nPlayer==3)
                        player3.setSaldo(player3.getSaldo()+200);
                    if(nPlayer==4){
                        player3.setSaldo(player3.getSaldo()+200);
                        player4.setSaldo(player4.getSaldo()+200);
                    }
                }if(currentPlayer==2){
                    player1.setSaldo(player1.getSaldo()+200);
                    if(nPlayer==3)
                        player3.setSaldo(player3.getSaldo()+200);
                    if(nPlayer==4){
                        player3.setSaldo(player3.getSaldo()+200);
                        player4.setSaldo(player4.getSaldo()+200);
                    }
                }if(currentPlayer==3){
                    if(nPlayer==3){
                        player1.setSaldo(player1.getSaldo()+200);
                        player2.setSaldo(player2.getSaldo()+200);
                    }if(nPlayer==4){
                        player1.setSaldo(player1.getSaldo()+200);
                        player2.setSaldo(player2.getSaldo()+200);
                        player4.setSaldo(player4.getSaldo()+200);
                    } 
                }if(currentPlayer==4){
                    player2.setSaldo(player2.getSaldo()+200);
                    player1.setSaldo(player1.getSaldo()+200);
                    player3.setSaldo(player3.getSaldo()+200);  
                }
                player.setSaldo(player.getSaldo()-((nPlayer-1)*200));
            break;
            case 6:
                player.setNcasella(1);
            break;
            case 7:
                Imprevisti.setVisible(true);
                flagImp = 1;
            break;
            case 8:
                player.setSaldo((player.getSaldo()+250));
            break;
            case 9:
                controllaPossibilita(player, 350);
                if(possibilita)
                    player.setSaldo((player.getSaldo()-350));
            break;
            case 10:
                player.setSaltaTurno(1);
            break;
            
        default:
               throw new AssertionError();
       }
        
        
   }
   
   public void inserisciImmProprieta(Player player){
       ImageIcon icon = new ImageIcon(caselle[player.getNcasella()].getNome()+" (1).png");
       switch (currentPlayer) {
           case 1:
               switch (player.getNproprieta() + player.getNsocieta()) {
                   case 1:
                       G11.setIcon(icon);
                       break;
                    case 2:
                       G12.setIcon(icon);
                       break;
                    case 3:
                       G13.setIcon(icon);
                       break;
                    case 4:
                       G14.setIcon(icon);
                       break;
                    case 5:
                       G15.setIcon(icon);
                       break;
                    case 6:
                       G16.setIcon(icon);
                       break;
                   default:
                      
               }

               break;
           case 2:
               switch (player.getNproprieta()+ player.getNsocieta()) {
                   case 1:
                       G31.setIcon(icon);
                       break;
                    case 2:
                       G32.setIcon(icon);
                       break;
                    case 3:
                       G33.setIcon(icon);
                       break;
                    case 4:
                       G34.setIcon(icon);
                       break;
                    case 5:
                       G35.setIcon(icon);
                       break;
                    case 6:
                       G36.setIcon(icon);
                       break;
                   default:
                       
               }

               break;
           case 3:
               switch (player.getNproprieta()+ player.getNsocieta()) {
                   case 1:
                       G21.setIcon(icon);
                       break;
                    case 2:
                       G22.setIcon(icon);
                       break;
                    case 3:
                       G23.setIcon(icon);
                       break;
                    case 4:
                       G24.setIcon(icon);
                       break;
                    case 5:
                       G25.setIcon(icon);
                       break;
                    case 6:
                       G26.setIcon(icon);
                       break;
                    default:
                       
               }
               break;
           case 4:
               switch (player.getNproprieta()+ player.getNsocieta()) {
                    case 1:
                       G41.setIcon(icon);
                       break;
                    case 2:
                       G42.setIcon(icon);
                       break;
                    case 3:
                       G43.setIcon(icon);
                       break;
                    case 4:
                       G44.setIcon(icon);
                       break;
                    case 5:
                       G45.setIcon(icon);
                       break;
                    case 6:
                       G46.setIcon(icon);
                       break;
                   default:
                       
               }

               break;

                   default:
                       throw new AssertionError();
        }
   }
               
   public void aggiornaSaldo(){
       
            Saldo1.setText(""+player1.getSaldo()+ "  M");
            Saldo2.setText(""+player2.getSaldo()+ "  M");
            Nome1.setText(""+nome1);
            Nome2.setText(""+nome2);
            Saldo3.setVisible(false);
            Saldo4.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
        if(nPlayer>2){
           Saldo3.setVisible(true);
           jLabel14.setVisible(true);
            Saldo3.setText(""+player3.getSaldo()+ "  M");
            Nome3.setText(""+nome3);
            if(nPlayer==4){
                Saldo4.setVisible(true);
                jLabel15.setVisible(true);
                Saldo4.setText(""+player4.getSaldo()+ "  M");
                Nome4.setText(""+nome4);
            }
        }
        
   }
   
   
   public void cambiaGiocatore(int n){
       if((n+1)>nPlayer){
           currentPlayer=1;
        
       }else{
           currentPlayer=n+1;
       }
       
       Dadi.setVisible(true);
       System.out.println(currentPlayer);
       ImageIcon icon = null;
       if(currentPlayer == 1)   
            icon = new ImageIcon("nave.png");
        if(currentPlayer == 2)   
            icon = new ImageIcon("cane.png");
        if(currentPlayer == 3)   
            icon = new ImageIcon("cappello.png");
        if(currentPlayer == 4)   
            icon = new ImageIcon("auto.png");
        Turno.setIcon(icon);
   }
   
   
   public void controllaPossibilita(Player player, int costo){
       if(player.getSaldo()>=costo){
           possibilita = true;
       }else{
           possibilita = false;
           if(player.getNproprieta()==0 && player.getNsocieta()==0){
               controllaSconfitta(player);
           }else if(caselle[player.getNcasella()] instanceof Proprieta || caselle[player.getNcasella()] instanceof Societa && controllaDisponibile(player.getNcasella())){
                Possibilità.setVisible(true);
                jLabel20.setText(caselle[player.getNcasella()].getNome());
                }else{
                        startTimerIpoteca(1000, player);
                    }
       }
   }
   
   public boolean controllaDisponibile(int n){
       boolean dis = false;
       if(caselle[n] instanceof Proprieta){
            Proprieta proprietaSelezionata = (Proprieta) caselle[n];
            if(proprietaSelezionata.isDisponibile())
                dis =true;
            else
                dis = false;
       }
       if(caselle[n] instanceof Societa){
            Societa proprietaSelezionata = (Societa) caselle[n];
            if(proprietaSelezionata.isDisponibile())
                dis =true;
            else
                dis = false;
       }
        return dis;
   }
   
   public void ipoteca(int n, Player player){
       if(player.getOrdine()[n] instanceof Proprieta){
            Proprieta proprietaSelezionata = (Proprieta) player.getOrdine()[n];
            player.setnProprieta(1);  // Riduce il numero di proprietà di 1
            proprietaSelezionata.setDisponibile(true);
            player.setSaldo(player.getSaldo() + proprietaSelezionata.getPzIpoteca());
            
            int l;
            for  (l = 0; l < player.getNproprieta()+player.getnSocieta(); l++) {
                Casella prop = player.getOrdine()[l];
                if (prop != null && prop.getNome().equals(proprietaSelezionata.getNome())) {
                    player.togliOrdine(l);
                    break;  // Esci dal ciclo una volta trovata e rimossa la proprietà
                }
            }
            
            eliminaImmagini(n);
        }
        
        if(player.getOrdine()[n] instanceof Societa){
            Societa proprietaSelezionata = (Societa) player.getOrdine()[n];
            player.setnSocieta(1);  // Riduce il numero di proprietà di 1
            proprietaSelezionata.setDisponibile(true);
            player.setSaldo(player.getSaldo() + proprietaSelezionata.getIpoteca());
            
            int l;
            for  (l = 0; l < player.getNproprieta()+player.getnSocieta(); l++) {
                Casella prop = player.getOrdine()[l];
                if (prop != null && prop.getNome().equals(proprietaSelezionata.getNome())) {
                    player.togliOrdine(l);
                    
                    break;  // Esci dal ciclo una volta trovata e rimossa la proprietà
                }
            }
            
            
            eliminaImmagini(n);
        }
        IpotecaPr.setVisible(false);
   }
   
   public void IpotecaProprieta(Player player){
       switch(currentPlayer){
           case 1: 
               I1.setIcon(G11.getIcon());
               I2.setIcon(G12.getIcon());
               I3.setIcon(G13.getIcon());
               I4.setIcon(G14.getIcon());
               I5.setIcon(G15.getIcon());
               I6.setIcon(G16.getIcon());
            break;
            case 2: 
               I1.setIcon(G31.getIcon());
               I2.setIcon(G32.getIcon());
               I3.setIcon(G33.getIcon());
               I4.setIcon(G34.getIcon());
               I5.setIcon(G35.getIcon());
               I6.setIcon(G36.getIcon());
            break;
            case 3: 
               I1.setIcon(G21.getIcon());
               I2.setIcon(G22.getIcon());
               I3.setIcon(G23.getIcon());
               I4.setIcon(G24.getIcon());
               I5.setIcon(G25.getIcon());
               I6.setIcon(G26.getIcon());
            break;
            case 4: 
               I1.setIcon(G41.getIcon());
               I2.setIcon(G42.getIcon());
               I3.setIcon(G43.getIcon());
               I4.setIcon(G44.getIcon());
               I5.setIcon(G45.getIcon());
               I6.setIcon(G46.getIcon());
            break;
            default:
       }
   }
   public void controllaSconfitta(Player player){
       calcolaVittoria();
       PartitaFinita.setVisible(true);
       NomeVittoria.setText(maxPatrimonio);
       if(player.getNumColore()==1){
           NomeSconfitta.setText(nome1);
            if(nPlayer==2){
                W1.setText(nome2);
                SaldoW1.setText(tot2+"");
            }else if(nPlayer==3){
                W2.setText(nome2);
                SaldoW2.setText(tot2+"");
                W3.setText(nome3);
                SaldoW3.setText(tot3+"");
            }else if(nPlayer==4){
                W1.setText(nome2);
                SaldoW1.setText(tot2+"");
                W2.setText(nome3);
                SaldoW2.setText(tot3+"");
                W3.setText(nome4);
                SaldoW3.setText(tot4+"");
            }
       }else if(player.getNumColore()==2){
           NomeSconfitta.setText(nome2);
            if(nPlayer==2){
                W1.setText(nome1);
                SaldoW1.setText(tot1+"");
            }else if(nPlayer==3){
                W2.setText(nome1);
                SaldoW2.setText(tot1+"");
                W3.setText(nome3);
                SaldoW3.setText(tot3+"");
            }else if(nPlayer==4){
                W1.setText(nome1);
                SaldoW1.setText(tot1+"");
                W2.setText(nome3);
                SaldoW2.setText(tot3+"");
                W3.setText(nome4);
                SaldoW3.setText(tot4+"");
            }
       }else if(player.getNumColore()==3){
           NomeSconfitta.setText(nome3);
            if(nPlayer==3){
                W2.setText(nome1);
                SaldoW2.setText(tot1+"");
                W3.setText(nome2);
                SaldoW3.setText(tot2+"");
            }else if(nPlayer==4){
                W1.setText(nome1);
                SaldoW1.setText(tot1+"");
                W2.setText(nome2);
                SaldoW2.setText(tot2+"");
                W3.setText(nome4);
                SaldoW3.setText(tot4+"");
            }
       }else if(player.getNumColore()==4){
                NomeSconfitta.setText(nome4);
                W1.setText(nome1);
                SaldoW1.setText(tot1+"");
                W2.setText(nome2);
                SaldoW2.setText(tot2+"");
                W3.setText(nome3);
                SaldoW3.setText(tot3+"");
            }
            
       }
       
   public void calcolaVittoria(){
       
       tot1 = calcolaPatrimonio(player1, tot1);
       tot2 = calcolaPatrimonio(player2, tot2);
       if(nPlayer==3)
            tot3 = calcolaPatrimonio(player3, tot3);
       if(nPlayer==4){
           tot3 = calcolaPatrimonio(player3, tot3);
            tot4 = calcolaPatrimonio(player4, tot4);
       }
       
       if(tot1 != tot2 && tot2!=tot3 && tot3!=tot4){
             tot = findMax(tot1,tot2,tot3,tot4);
            
       }else{
           
           tot = findMax(tot1,tot2,tot3,tot4);
           trovaMaxPari(tot1, tot2, player1, player2);
           if(nPlayer==3){
                trovaMaxPari(tot1, tot3, player1, player3);
                trovaMaxPari(tot2, tot3, player2, player3);
           }
           if(nPlayer==4){
               trovaMaxPari(tot1, tot3, player1, player3);
                trovaMaxPari(tot2, tot3, player2, player3);
                trovaMaxPari(tot1, tot4, player1, player4);
                trovaMaxPari(tot2, tot4, player2, player4);
                trovaMaxPari(tot3, tot4, player3, player4);
           }
       }
       System.out.println(tot +" "+ tot1 + " " +tot2+ " " +  tot3 + " " + tot4);
       if(tot==tot1)
            maxPatrimonio=nome1;
        if(tot==tot2)
            maxPatrimonio=nome2;
        if(tot==tot3)
            maxPatrimonio=nome3;
        if(tot==tot4)
            maxPatrimonio=nome4;
   }
   
   public int calcolaPatrimonio(Player p, int tot){
       tot=p.getSaldo();
       
       for (Proprieta prop : p.getProprieta()) {
            if (prop != null) {
                int valoreIpoteca = prop.getPzIpoteca();
                int valoreCase = (valoreIpoteca / 5) * prop.getnCase();
                tot = tot + valoreIpoteca + valoreCase;
            }
        }
       tot= tot+(player1.getNsocieta()*750);
       return tot;
       
   }
   
   public void trovaMaxPari(int t1, int t2, Player p1, Player p2){
       int n;
       if(t1 == tot && t2==t1){
               n = trovaMaxProp(p1, p2);
               if(n==1)
                   tot=t1;
               if(n==2)
                   tot=t2;
           }
   }
   public int trovaMaxProp(Player p1, Player p2){
       int n=0;
       if(p1.getNproprieta()>p2.getNproprieta())
           n=1;
       if(p1.getNproprieta()<p2.getNproprieta())
           n=2;
       if(p1.getNproprieta()==p2.getNproprieta()){
           if(p1.getSaldo()>p2.getSaldo())
               n=2;
           if(p1.getSaldo()>p2.getSaldo())
               n=1;
       }
       return n;
   }
    public int findMax(int a, int b, int c, int d) {
        int max = a; // Supponiamo inizialmente che il primo numero sia il massimo

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }

        return max;
    }
   
        
    public void eliminaImmagini(int i){
        Ipoteca.setVisible(false);
        switch (currentPlayer) {
           case 1:
               switch (i) {
                   case 0:
                       G11.setIcon(G12.getIcon());
                       G12.setIcon(G13.getIcon());
                       G13.setIcon(G14.getIcon());
                       G14.setIcon(G15.getIcon());
                       G15.setIcon(G16.getIcon());
                       G16.setIcon(null);
                       break;
                    case 1:
                       G12.setIcon(G13.getIcon());
                       G13.setIcon(G14.getIcon());
                       G14.setIcon(G15.getIcon());
                       G15.setIcon(G16.getIcon());
                       G16.setIcon(null);
                       break;
                    case 2:
                       G13.setIcon(G14.getIcon());
                       G14.setIcon(G15.getIcon());
                       G15.setIcon(G16.getIcon());
                       G16.setIcon(null);
                       break;
                    case 3:
                       G14.setIcon(G15.getIcon());
                       G15.setIcon(G16.getIcon());
                       G16.setIcon(null);
                       break;
                    case 4:
                       G15.setIcon(G16.getIcon());
                       G16.setIcon(null);
                       break;
                    case 5:
                       G16.setIcon(null);
                       break;
                    default:
                      
               }

               break;
           case 2:
               switch (i) {
                   case 0:
                       G31.setIcon(G32.getIcon());
                       G32.setIcon(G33.getIcon());
                       G33.setIcon(G34.getIcon());
                       G34.setIcon(G35.getIcon());
                       G35.setIcon(G36.getIcon());
                       G36.setIcon(null);
                       break;
                    case 1:
                       G32.setIcon(G33.getIcon());
                       G33.setIcon(G34.getIcon());
                       G34.setIcon(G35.getIcon());
                       G35.setIcon(G36.getIcon());
                       G36.setIcon(null);
                       break;
                    case 2:
                       G33.setIcon(G34.getIcon());
                       G34.setIcon(G35.getIcon());
                       G35.setIcon(G36.getIcon());
                       G36.setIcon(null);
                       break;
                    case 3:
                       G34.setIcon(G35.getIcon());
                       G35.setIcon(G36.getIcon());
                       G36.setIcon(null);
                       break;
                    case 4:
                       G35.setIcon(G36.getIcon());
                       G36.setIcon(null);
                       break;
                    case 5:
                       G36.setIcon(null);
                       break;
                    default:
                       
               }

               break;
           case 3:
               switch (i) {
                   case 0:
                       G21.setIcon(G22.getIcon());
                       G22.setIcon(G23.getIcon());
                       G23.setIcon(G24.getIcon());
                       G24.setIcon(G25.getIcon());
                       G25.setIcon(G26.getIcon());
                       G26.setIcon(null);
                       break;
                    case 1:
                       G22.setIcon(G23.getIcon());
                       G23.setIcon(G24.getIcon());
                       G24.setIcon(G25.getIcon());
                       G25.setIcon(G26.getIcon());
                       G26.setIcon(null);
                       break;
                    case 2:
                       G23.setIcon(G24.getIcon());
                       G24.setIcon(G25.getIcon());
                       G25.setIcon(G26.getIcon());
                       G26.setIcon(null);
                       break;
                    case 3:
                       G24.setIcon(G25.getIcon());
                       G25.setIcon(G26.getIcon());
                       G26.setIcon(null);
                       break;
                    case 4:
                       G25.setIcon(G26.getIcon());
                       G26.setIcon(null);
                       break;
                    case 5:
                       G26.setIcon(null);
                       break;
                    default:
                       
               }
               break;
           case 4:
               switch (i) {
                    case 0:
                       G41.setIcon(G42.getIcon());
                       G42.setIcon(G43.getIcon());
                       G43.setIcon(G44.getIcon());
                       G44.setIcon(G45.getIcon());
                       G45.setIcon(G46.getIcon());
                       G46.setIcon(null);
                       break;
                    case 1:
                       G42.setIcon(G43.getIcon());
                       G43.setIcon(G44.getIcon());
                       G44.setIcon(G45.getIcon());
                       G45.setIcon(G46.getIcon());
                       G46.setIcon(null);
                       break;
                    case 2:
                       G43.setIcon(G44.getIcon());
                       G44.setIcon(G45.getIcon());
                       G45.setIcon(G46.getIcon());
                       G46.setIcon(null);
                       break;
                    case 3:
                       G44.setIcon(G45.getIcon());
                       G45.setIcon(G46.getIcon());
                       G46.setIcon(null);
                       break;
                    case 4:
                       G45.setIcon(G46.getIcon());
                       G46.setIcon(null);
                       break;
                    case 5:
                       G46.setIcon(null);
                       break;
                   default:
                       
               }

               break;

                   default:
                       throw new AssertionError();
        }
    }
   
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PartitaTerminata = new javax.swing.JPanel();
        Vincitore = new javax.swing.JLabel();
        W4 = new javax.swing.JLabel();
        W5 = new javax.swing.JLabel();
        W7 = new javax.swing.JLabel();
        W6 = new javax.swing.JLabel();
        SaldoW7 = new javax.swing.JLabel();
        SaldoW4 = new javax.swing.JLabel();
        SaldoW5 = new javax.swing.JLabel();
        SaldoW6 = new javax.swing.JLabel();
        Esci = new javax.swing.JButton();
        Annulla = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        PartitaFinita = new javax.swing.JPanel();
        NomeVittoria = new javax.swing.JLabel();
        NomeSconfitta = new javax.swing.JLabel();
        W3 = new javax.swing.JLabel();
        W2 = new javax.swing.JLabel();
        W1 = new javax.swing.JLabel();
        SaldoW3 = new javax.swing.JLabel();
        SaldoW2 = new javax.swing.JLabel();
        SaldoW1 = new javax.swing.JLabel();
        TerminaSconfitta = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        IpotecaPr = new javax.swing.JPanel();
        I4 = new javax.swing.JButton();
        I6 = new javax.swing.JButton();
        I5 = new javax.swing.JButton();
        I3 = new javax.swing.JButton();
        I2 = new javax.swing.JButton();
        I1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        Possibilità = new javax.swing.JPanel();
        TerminaTurno1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Case = new javax.swing.JPanel();
        TerminaTurno2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Proprieta = new javax.swing.JPanel();
        Citta = new javax.swing.JLabel();
        ImmProp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Compra = new javax.swing.JButton();
        TerminaTurno = new javax.swing.JButton();
        PagaETermina = new javax.swing.JButton();
        Costruisci = new javax.swing.JButton();
        Ipoteca = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ImpProb = new javax.swing.JPanel();
        OkImpProb = new javax.swing.JButton();
        Imprevisti = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EsciDiPrigione = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Si = new javax.swing.JButton();
        No = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Tabellone = new javax.swing.JPanel();
        Dadi = new javax.swing.JButton();
        LabelDadi1 = new javax.swing.JLabel();
        LabelDadi2 = new javax.swing.JLabel();
        Nome4 = new javax.swing.JLabel();
        Nome1 = new javax.swing.JLabel();
        Nome3 = new javax.swing.JLabel();
        Nome2 = new javax.swing.JLabel();
        Saldo4 = new javax.swing.JLabel();
        Saldo3 = new javax.swing.JLabel();
        Saldo2 = new javax.swing.JLabel();
        Saldo1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Pedina19 = new javax.swing.JLabel();
        Pedina21 = new javax.swing.JLabel();
        Pedina20 = new javax.swing.JLabel();
        Pedina18 = new javax.swing.JLabel();
        Pedina17 = new javax.swing.JLabel();
        Pedina28 = new javax.swing.JLabel();
        Pedina29 = new javax.swing.JLabel();
        Pedina30 = new javax.swing.JLabel();
        Pedina31 = new javax.swing.JLabel();
        Pedina16 = new javax.swing.JLabel();
        Pedina27 = new javax.swing.JLabel();
        Pedina26 = new javax.swing.JLabel();
        Pedina25 = new javax.swing.JLabel();
        Pedina24 = new javax.swing.JLabel();
        Pedina22 = new javax.swing.JLabel();
        Pedina23 = new javax.swing.JLabel();
        Pedina8 = new javax.swing.JLabel();
        Pedina7 = new javax.swing.JLabel();
        Pedina6 = new javax.swing.JLabel();
        Pedina5 = new javax.swing.JLabel();
        Pedina4 = new javax.swing.JLabel();
        Pedina3 = new javax.swing.JLabel();
        Pedina2 = new javax.swing.JLabel();
        Pedina0 = new javax.swing.JLabel();
        Pedina9 = new javax.swing.JLabel();
        Pedina10 = new javax.swing.JLabel();
        Pedina11 = new javax.swing.JLabel();
        Pedina12 = new javax.swing.JLabel();
        Pedina13 = new javax.swing.JLabel();
        Pedina14 = new javax.swing.JLabel();
        Pedina15 = new javax.swing.JLabel();
        Pedina1 = new javax.swing.JLabel();
        G26 = new javax.swing.JLabel();
        G25 = new javax.swing.JLabel();
        G24 = new javax.swing.JLabel();
        G23 = new javax.swing.JLabel();
        G22 = new javax.swing.JLabel();
        G21 = new javax.swing.JLabel();
        G16 = new javax.swing.JLabel();
        G15 = new javax.swing.JLabel();
        G14 = new javax.swing.JLabel();
        G13 = new javax.swing.JLabel();
        G12 = new javax.swing.JLabel();
        G11 = new javax.swing.JLabel();
        G46 = new javax.swing.JLabel();
        G45 = new javax.swing.JLabel();
        G44 = new javax.swing.JLabel();
        G43 = new javax.swing.JLabel();
        G42 = new javax.swing.JLabel();
        G41 = new javax.swing.JLabel();
        G32 = new javax.swing.JLabel();
        G36 = new javax.swing.JLabel();
        G35 = new javax.swing.JLabel();
        G34 = new javax.swing.JLabel();
        G33 = new javax.swing.JLabel();
        G31 = new javax.swing.JLabel();
        TerminaPartita = new javax.swing.JButton();
        Turno = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Casa11 = new javax.swing.JLabel();
        Casa10 = new javax.swing.JLabel();
        Casa9 = new javax.swing.JLabel();
        Casa8 = new javax.swing.JLabel();
        Casa7 = new javax.swing.JLabel();
        Casa6 = new javax.swing.JLabel();
        Casa5 = new javax.swing.JLabel();
        Casa4 = new javax.swing.JLabel();
        Casa3 = new javax.swing.JLabel();
        Casa2 = new javax.swing.JLabel();
        Casa12 = new javax.swing.JLabel();
        Casa13 = new javax.swing.JLabel();
        Casa14 = new javax.swing.JLabel();
        Casa15 = new javax.swing.JLabel();
        Casa16 = new javax.swing.JLabel();
        Casa1 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        P4 = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Setting = new javax.swing.JPanel();
        Musica = new javax.swing.JButton();
        Line = new javax.swing.JLabel();
        Info = new javax.swing.JButton();
        X = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Conferma = new javax.swing.JPanel();
        G4 = new javax.swing.JLabel();
        G1 = new javax.swing.JLabel();
        G2 = new javax.swing.JLabel();
        G3 = new javax.swing.JLabel();
        BtnIndietro = new javax.swing.JButton();
        BtnConferma = new javax.swing.JButton();
        BtnModifica = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Names = new javax.swing.JPanel();
        Sett = new javax.swing.JButton();
        Gioca = new javax.swing.JButton();
        Player1 = new javax.swing.JTextField();
        Player2 = new javax.swing.JTextField();
        Player3 = new javax.swing.JTextField();
        Player4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PartitaTerminata.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Vincitore.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Vincitore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(Vincitore, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 220, 50));

        W4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        W4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(W4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 120, 20));

        W5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        W5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(W5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 130, 20));

        W7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        W7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(W7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 120, 20));

        W6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        W6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(W6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 130, 20));

        SaldoW7.setFont(new java.awt.Font("Swis721 BlkEx BT", 0, 12)); // NOI18N
        SaldoW7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(SaldoW7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 120, 40));

        SaldoW4.setFont(new java.awt.Font("Swis721 BlkEx BT", 0, 12)); // NOI18N
        SaldoW4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(SaldoW4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 120, 40));

        SaldoW5.setFont(new java.awt.Font("Swis721 BlkEx BT", 0, 12)); // NOI18N
        SaldoW5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(SaldoW5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 130, 40));

        SaldoW6.setFont(new java.awt.Font("Swis721 BlkEx BT", 0, 12)); // NOI18N
        SaldoW6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaTerminata.add(SaldoW6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 130, 40));

        Esci.setBorderPainted(false);
        Esci.setContentAreaFilled(false);
        Esci.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Esci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsciActionPerformed(evt);
            }
        });
        PartitaTerminata.add(Esci, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 140, 40));

        Annulla.setBorderPainted(false);
        Annulla.setContentAreaFilled(false);
        Annulla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Annulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnullaActionPerformed(evt);
            }
        });
        PartitaTerminata.add(Annulla, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 140, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PartitaTerminata (4).png"))); // NOI18N
        PartitaTerminata.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        getContentPane().add(PartitaTerminata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 500, 500));

        PartitaFinita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NomeVittoria.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NomeVittoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaFinita.add(NomeVittoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 220, 40));

        NomeSconfitta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NomeSconfitta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaFinita.add(NomeSconfitta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 220, 40));

        W3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        W3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaFinita.add(W3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 120, 10));

        W2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        W2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaFinita.add(W2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 10));

        W1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        W1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartitaFinita.add(W1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 120, -1));
        PartitaFinita.add(SaldoW3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 120, 30));
        PartitaFinita.add(SaldoW2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 120, 30));
        PartitaFinita.add(SaldoW1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 120, 30));

        TerminaSconfitta.setBorderPainted(false);
        TerminaSconfitta.setContentAreaFilled(false);
        TerminaSconfitta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TerminaSconfitta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminaSconfittaActionPerformed(evt);
            }
        });
        PartitaFinita.add(TerminaSconfitta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 140, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PartitaFinita (1).png"))); // NOI18N
        PartitaFinita.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        getContentPane().add(PartitaFinita, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 500, 450));

        IpotecaPr.setBackground(new java.awt.Color(178, 244, 167));
        IpotecaPr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        I4.setBorderPainted(false);
        I4.setContentAreaFilled(false);
        I4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I4ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 50, 80));

        I6.setBorderPainted(false);
        I6.setContentAreaFilled(false);
        I6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I6ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 50, 80));

        I5.setBorderPainted(false);
        I5.setContentAreaFilled(false);
        I5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I5ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 50, 80));

        I3.setBorderPainted(false);
        I3.setContentAreaFilled(false);
        I3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I3ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 50, 80));

        I2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I2.setBorderPainted(false);
        I2.setContentAreaFilled(false);
        I2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I2ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 50, 80));

        I1.setBorderPainted(false);
        I1.setContentAreaFilled(false);
        I1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1ActionPerformed(evt);
            }
        });
        IpotecaPr.add(I1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, 80));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ipotecaa.png"))); // NOI18N
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        IpotecaPr.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 250));

        getContentPane().add(IpotecaPr, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 300, 250));

        Possibilità.setBackground(new java.awt.Color(178, 244, 167));
        Possibilità.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TerminaTurno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TerminaTurno.png"))); // NOI18N
        TerminaTurno1.setBorderPainted(false);
        TerminaTurno1.setContentAreaFilled(false);
        TerminaTurno1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TerminaTurno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminaTurno1ActionPerformed(evt);
            }
        });
        Possibilità.add(TerminaTurno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Possibilità.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poss.png"))); // NOI18N
        Possibilità.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 220));

        getContentPane().add(Possibilità, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 300, 220));

        Case.setBackground(new java.awt.Color(178, 244, 167));
        Case.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TerminaTurno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TerminaTurno.png"))); // NOI18N
        TerminaTurno2.setBorderPainted(false);
        TerminaTurno2.setContentAreaFilled(false);
        TerminaTurno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TerminaTurno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminaTurno2ActionPerformed(evt);
            }
        });
        Case.add(TerminaTurno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Case.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 110, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Casee.png"))); // NOI18N
        Case.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 220));

        getContentPane().add(Case, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 300, 220));

        Proprieta.setBackground(new java.awt.Color(178, 244, 167));
        Proprieta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Citta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Citta.setText("Sei arrivato a : ");
        Proprieta.add(Citta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        ImmProp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImmProp.setInheritsPopupMenu(false);
        Proprieta.add(ImmProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 95, 95));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Proprieta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 50, 40));

        Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Compra.png"))); // NOI18N
        Compra.setBorderPainted(false);
        Compra.setContentAreaFilled(false);
        Compra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompraActionPerformed(evt);
            }
        });
        Proprieta.add(Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

        TerminaTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TerminaTurno.png"))); // NOI18N
        TerminaTurno.setBorderPainted(false);
        TerminaTurno.setContentAreaFilled(false);
        TerminaTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TerminaTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminaTurnoActionPerformed(evt);
            }
        });
        Proprieta.add(TerminaTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        PagaETermina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PagaETermina.png"))); // NOI18N
        PagaETermina.setBorderPainted(false);
        PagaETermina.setContentAreaFilled(false);
        PagaETermina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PagaETermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagaETerminaActionPerformed(evt);
            }
        });
        Proprieta.add(PagaETermina, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, -1));

        Costruisci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Costruisci.png"))); // NOI18N
        Costruisci.setBorderPainted(false);
        Costruisci.setContentAreaFilled(false);
        Costruisci.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Costruisci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostruisciActionPerformed(evt);
            }
        });
        Proprieta.add(Costruisci, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        Ipoteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ipoteca.png"))); // NOI18N
        Ipoteca.setBorderPainted(false);
        Ipoteca.setContentAreaFilled(false);
        Ipoteca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ipoteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpotecaActionPerformed(evt);
            }
        });
        Proprieta.add(Ipoteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Proprieta.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Proprieta.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Proprieta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 220));

        getContentPane().add(Proprieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 300, 220));

        ImpProb.setBackground(new java.awt.Color(178, 244, 167));
        ImpProb.setForeground(new java.awt.Color(178, 244, 167));
        ImpProb.setMinimumSize(new java.awt.Dimension(300, 150));
        ImpProb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OkImpProb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Continua.png"))); // NOI18N
        OkImpProb.setBorderPainted(false);
        OkImpProb.setContentAreaFilled(false);
        OkImpProb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OkImpProb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkImpProbActionPerformed(evt);
            }
        });
        ImpProb.add(OkImpProb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 30));

        Imprevisti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Impr.png"))); // NOI18N
        Imprevisti.setBorderPainted(false);
        Imprevisti.setContentAreaFilled(false);
        Imprevisti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Imprevisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprevistiActionPerformed(evt);
            }
        });
        ImpProb.add(Imprevisti, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImpProb.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 140));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ImpProb.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 210));

        getContentPane().add(ImpProb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 210));

        EsciDiPrigione.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        EsciDiPrigione.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 30));

        Si.setBorderPainted(false);
        Si.setContentAreaFilled(false);
        Si.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });
        EsciDiPrigione.add(Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 30));

        No.setBorderPainted(false);
        No.setContentAreaFilled(false);
        No.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });
        EsciDiPrigione.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EsciDiPrigione.png"))); // NOI18N
        EsciDiPrigione.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 160));

        getContentPane().add(EsciDiPrigione, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 270, 160));

        Tabellone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dadi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TiraDadi.png"))); // NOI18N
        Dadi.setContentAreaFilled(false);
        Dadi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadiActionPerformed(evt);
            }
        });
        Tabellone.add(Dadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 123, 57));
        Tabellone.add(LabelDadi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 60, 60));
        Tabellone.add(LabelDadi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 60, 60));

        Nome4.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        Nome4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Nome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 160, 40));

        Nome1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        Nome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));

        Nome3.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        Nome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Nome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 180, 40));

        Nome2.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        Nome2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Nome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 180, 40));

        Saldo4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Saldo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Saldo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 110, 20));

        Saldo3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Saldo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Saldo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 110, 20));

        Saldo2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Saldo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Saldo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 110, 20));

        Saldo1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Saldo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Saldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 110, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rectangle 54.png"))); // NOI18N
        jLabel11.setText("jLabel10");
        Tabellone.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 110, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rectangle 54.png"))); // NOI18N
        Tabellone.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 110, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rectangle 54.png"))); // NOI18N
        Tabellone.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 110, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rectangle 54.png"))); // NOI18N
        Tabellone.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 110, 20));

        Pedina19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 40, 40));

        Pedina21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 40, 40));

        Pedina20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 40, 40));

        Pedina18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 40, 40));

        Pedina17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 40, 40));

        Pedina28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina28, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 40, 40));

        Pedina29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina29, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 40, 40));

        Pedina30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina30, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 40, 40));

        Pedina31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina31, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 40, 40));

        Pedina16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 40, 40));

        Pedina27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina27, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 40, 40));

        Pedina26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina26, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 40, 40));

        Pedina25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 40, 40));

        Pedina24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina24, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 40, 40));

        Pedina22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 40, 40));

        Pedina23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 40, 40));

        Pedina8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 40, 40));

        Pedina7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 40, 40));

        Pedina6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 40, 40));

        Pedina5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 40, 40));

        Pedina4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 40, 40));

        Pedina3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 40, 40));

        Pedina2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 40, 40));

        Pedina0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina0, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 40, 40));

        Pedina9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 40, 40));

        Pedina10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 40, 40));

        Pedina11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 40, 40));

        Pedina12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 40, 40));

        Pedina13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 40, 40));

        Pedina14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 40, 40));

        Pedina15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 40, 40));

        Pedina1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Pedina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 40, 40));
        Tabellone.add(G26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 50, 80));
        Tabellone.add(G25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 50, 80));
        Tabellone.add(G24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 50, 80));
        Tabellone.add(G23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 50, 80));
        Tabellone.add(G22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 50, 80));
        Tabellone.add(G21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 50, 80));
        Tabellone.add(G16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 50, 80));
        Tabellone.add(G15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 50, 80));
        Tabellone.add(G14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 50, 80));
        Tabellone.add(G13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 50, 80));
        Tabellone.add(G12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 50, 80));
        Tabellone.add(G11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 50, 80));
        Tabellone.add(G46, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 50, 80));
        Tabellone.add(G45, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 50, 80));
        Tabellone.add(G44, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 50, 80));
        Tabellone.add(G43, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 50, 80));
        Tabellone.add(G42, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 50, 80));
        Tabellone.add(G41, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 50, 80));

        G32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(G32, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 50, 80));
        Tabellone.add(G36, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 50, 80));
        Tabellone.add(G35, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 50, 80));
        Tabellone.add(G34, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 50, 80));

        G33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(G33, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 50, 80));
        Tabellone.add(G31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 50, 80));

        TerminaPartita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TerminaPartita.png"))); // NOI18N
        TerminaPartita.setBorderPainted(false);
        TerminaPartita.setContentAreaFilled(false);
        TerminaPartita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TerminaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminaPartitaActionPerformed(evt);
            }
        });
        Tabellone.add(TerminaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 180, 25));
        Tabellone.add(Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 40, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TURN (1).png"))); // NOI18N
        Tabellone.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        Casa11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 40, 40));

        Casa10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 40, 40));

        Casa9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 40, 40));

        Casa8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 40, 40));

        Casa7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 40, 40));

        Casa6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 40, 40));

        Casa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 40, 40));

        Casa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 40, 40));

        Casa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 40, 40));

        Casa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 40, 40));

        Casa12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 40, 40));

        Casa13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 40, 40));

        Casa14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 40, 40));

        Casa15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 40, 40));

        Casa16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 40, 40));

        Casa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(Casa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 40, 40));

        P2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 40, 40));

        P1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 40, 40));

        P4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 40, 40));

        P3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tabellone.add(P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabellone.png"))); // NOI18N
        Tabellone.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 600));

        getContentPane().add(Tabellone, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 600));

        Setting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Musica.setBorderPainted(false);
        Musica.setContentAreaFilled(false);
        Musica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusicaActionPerformed(evt);
            }
        });
        Setting.add(Musica, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 110, 110));

        Line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line 11.png"))); // NOI18N
        Setting.add(Line, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 100, 90));

        Info.setBorderPainted(false);
        Info.setContentAreaFilled(false);
        Info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });
        Setting.add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 110, 110));

        X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/X.png"))); // NOI18N
        X.setBorderPainted(false);
        X.setContentAreaFilled(false);
        X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        Setting.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 30, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Setting (2).png"))); // NOI18N
        Setting.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        getContentPane().add(Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 500, -1));

        Conferma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G4.setText("jLabel9");
        G4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Conferma.add(G4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 130, 30));

        G1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1.setText("jLabel9");
        G1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Conferma.add(G1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, 35));

        G2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G2.setText("jLabel9");
        G2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Conferma.add(G2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 120, 35));

        G3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3.setText("jLabel9");
        G3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Conferma.add(G3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 130, 30));

        BtnIndietro.setBorderPainted(false);
        BtnIndietro.setContentAreaFilled(false);
        BtnIndietro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIndietroActionPerformed(evt);
            }
        });
        Conferma.add(BtnIndietro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 80, 30));

        BtnConferma.setBorderPainted(false);
        BtnConferma.setContentAreaFilled(false);
        BtnConferma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfermaActionPerformed(evt);
            }
        });
        Conferma.add(BtnConferma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 253, 90, 30));

        BtnModifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modifica.png"))); // NOI18N
        BtnModifica.setContentAreaFilled(false);
        BtnModifica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModifica.setDefaultCapable(false);
        BtnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificaActionPerformed(evt);
            }
        });
        Conferma.add(BtnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 253, 110, 30));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Conferma.png"))); // NOI18N
        Conferma.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 296));

        getContentPane().add(Conferma, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 410, 296));

        Names.setMinimumSize(new java.awt.Dimension(966, 600));
        Names.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sett.setBorderPainted(false);
        Sett.setContentAreaFilled(false);
        Sett.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettActionPerformed(evt);
            }
        });
        Names.add(Sett, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, -1, 60));

        Gioca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gioca .png"))); // NOI18N
        Gioca.setBorderPainted(false);
        Gioca.setContentAreaFilled(false);
        Gioca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gioca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiocaActionPerformed(evt);
            }
        });
        Names.add(Gioca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 90, 40));

        Player1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        Player1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Player1.setBorder(null);
        Player1.setOpaque(true);
        Names.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 150, 60));

        Player2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        Player2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Player2.setBorder(null);
        Player2.setOpaque(true);
        Names.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 160, 60));

        Player3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        Player3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Player3.setBorder(null);
        Player3.setOpaque(true);
        Names.add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 150, 60));

        Player4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        Player4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Player4.setBorder(null);
        Player4.setOpaque(true);
        Names.add(Player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 150, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Name.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1054, 611));
        jLabel1.setMinimumSize(new java.awt.Dimension(1054, 611));
        Names.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        getContentPane().add(Names, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 966, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GiocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiocaActionPerformed
        // TODO add your handling code here:
         ImageIcon icon = null;
        String nomeP1 = Player1.getText().toLowerCase();
        String nomeP2 = Player2.getText().toLowerCase();
        String nomeP3 = Player3.getText().toLowerCase();
        String nomeP4 = Player4.getText().toLowerCase();
        
       
          
        int conta = 4;
        if (nomeP1.isEmpty()) conta--;
        if (nomeP2.isEmpty()) conta--;
        if (nomeP3.isEmpty()) conta--;
        if (nomeP4.isEmpty()) conta--;
        
        nome1 = nomeP1;
        nome2 = nomeP2;
        nome3 = nomeP3;
        nome4 = nomeP4;
        if(nomeP1.length() < 15 && nomeP2.length() < 15 && nomeP3.length() < 15 && nomeP4.length() < 15){
            if(conta<2){
                    icon = new ImageIcon("DueGiocatori.png");   
                    BtnConferma.setVisible(false);
                    BtnIndietro.setVisible(false);
                    BtnModifica.setVisible(true);
                    G1.setText(""+nome1);
                    G2.setText(""+nome2);
                    G3.setText(""+nome3);
                    G4.setText(""+nome4);
                    BtnModifica.setVisible(true);
            }else if (conta>=2) {
                // Verifica se uno o più giocatori sono vuoti
                if(nomeP1.equals(nomeP2) && nomeP1.isEmpty()==false || nomeP1.equals(nomeP3) && !nomeP1.isEmpty()|| nomeP1.equals(nomeP4) && nomeP1.isEmpty()==false|| nomeP3.equals(nomeP2)  && nomeP2.isEmpty()==false|| nomeP4.equals(nomeP2) && nomeP2.isEmpty()==false|| nomeP3.equals(nomeP4) && nomeP3.isEmpty()==false ){
                        icon = new ImageIcon("NomiDiversi.png");    
                        BtnConferma.setVisible(false);
                        BtnIndietro.setVisible(false);
                        BtnModifica.setVisible(true);
                        G1.setText(""+nome1);
                        G2.setText(""+nome2);
                        G3.setText(""+nome3);
                        G4.setText(""+nome4);
                }else{
                    nome1 = nomeP1;
                    nome2 = nomeP2;
                    nome3 = nomeP3;
                    nome4 = nomeP4;
                        icon = new ImageIcon("Conferma.png");
                        BtnConferma.setVisible(true);
                        BtnIndietro.setVisible(true);
                        BtnModifica.setVisible(false);
                        if(!nomeP1.isEmpty() && nomeP2.isEmpty() && !nomeP3.isEmpty() &&  nomeP4.isEmpty()){
                            nome2 = nome3;
                            nome3 = " ";
                        }else if(!nomeP1.isEmpty() && nomeP2.isEmpty() && !nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome2 = nome3;
                            nome3 = nome4;
                            nome3 = " ";
                            nome4 = " ";
                        }else if(nomeP1.isEmpty() && !nomeP2.isEmpty() && !nomeP3.isEmpty() &&  nomeP4.isEmpty()){
                            nome1 = nome2;
                            nome2 = nome3;
                            nome3 = " ";
                        }else if(nomeP1.isEmpty() && !nomeP2.isEmpty() && !nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome1 = nome2;
                            nome2 = nome3;
                            nome3 = nome4;
                            nome4 = " ";
                        }else if(nomeP1.isEmpty() && nomeP2.isEmpty() && !nomeP3.isEmpty() &&  nomeP4.isEmpty()){
                            nome2 = nome3;
                            nome3 = " ";
                        }else if(nomeP1.isEmpty() && !nomeP2.isEmpty() && nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome1 = nome2;
                            nome2 = nome4;
                            nome4 = " ";
                        }else if(!nomeP1.isEmpty() && nomeP2.isEmpty() && !nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome2 = nome3;
                            nome3 = nome4;
                            nome4 = " ";
                        }else if(!nomeP1.isEmpty() && !nomeP2.isEmpty() && nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome3 = nome4;
                            nome4 = " ";
                        }else if(!nomeP1.isEmpty() && nomeP2.isEmpty() && nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome2 = nome4;
                            nome4 = " ";
                        }else if(nomeP1.isEmpty() && nomeP2.isEmpty() && !nomeP3.isEmpty() &&  !nomeP4.isEmpty()){
                            nome1 = nome3;
                            nome2 = nome4;
                            nome3 = " ";
                            nome4 = " ";
                            
                        }
                        G1.setText(""+nome1);
                        G2.setText(""+nome2);
                        G3.setText(""+nome3);
                        G4.setText(""+nome4);
                }
            }
            
            
            
        }else{
                        
                icon = new ImageIcon("15Caratteri.png");
                BtnConferma.setVisible(false);
                BtnIndietro.setVisible(false);
                BtnModifica.setVisible(true);
        }
        
        
        Conferma.setVisible(true);
        G1.setText(""+nome1);
        G2.setText(""+nome2);
        G3.setText(""+nome3);
        G4.setText(""+nome4); 
        jLabel13.setIcon(icon);
        istanziaPlayer(conta);
    }//GEN-LAST:event_GiocaActionPerformed

    private void DadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DadiActionPerformed
        // TODO add your handling code here:
        int dado1, dado2;
        Random random = new Random();
        dado1 = random.nextInt(5)+1;
        dado2 = random.nextInt(5)+1;
        
        
        ImageIcon icon = new ImageIcon("dadi.gif");
        LabelDadi1.setIcon(icon);
        LabelDadi2.setIcon(icon);
        startTimer(dado1, dado2, 1000);
        nDadi= dado1+dado2;
        
        if(flagDadi==0){
            
            if(nPlayer==2)
                numPrecedente = new int[2];
            if(nPlayer==3)
                numPrecedente = new int[3];
            if(nPlayer==4)
                numPrecedente = new int[4];


            if(currentPlayer==1){
                startTimer2(nDadi, player1, 1500,numPrecedente);
                numPrecedente[0] = player1.getNcasella();
            }
            if(currentPlayer==2){
                startTimer2(nDadi, player2, 1500, numPrecedente);
                numPrecedente[1] = player2.getNcasella();
            }
            if(currentPlayer==3){
                startTimer2(nDadi, player3, 1500, numPrecedente);
                numPrecedente[2] = player3.getNcasella();
            }
            if(currentPlayer==4){
                startTimer2(nDadi, player4, 1500, numPrecedente);
                numPrecedente[3] = player4.getNcasella();
            }
            Dadi.setVisible(false);
            LabelDadi1.setVisible(true);
            LabelDadi2.setVisible(true);
        }if(flagDadi==1){
            Player player = null;
            if(currentPlayer==1)
                player=player1;
            if(currentPlayer==2)
                player=player2;  
            if(currentPlayer==3)
                player=player3;  
            if(currentPlayer==4)
                player=player4;
            
            if(nDadi>7)
                player.setSaldo(player.getSaldo()+400);
            else
                player.setSaldo(player.getSaldo()-200);
            OkImpProb.setEnabled(true);
            flagDadi=0;
        }if(flagDadi==2){
            if(dado1==dado2){
                player1.setPrigione(false);
                player1.setSaltaTurno(0);
                flagDadi=0;
        }
    }
    }//GEN-LAST:event_DadiActionPerformed

    private void OkImpProbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkImpProbActionPerformed
        // TODO add your handling code here:
        ImpProb.setVisible(false);
        aggiornaSaldo();
        cambiaGiocatore(currentPlayer);
    }//GEN-LAST:event_OkImpProbActionPerformed

    private void ImprevistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprevistiActionPerformed
        // TODO add your handling code here:
        if(currentPlayer==1)
            Imprevisti(player1, player1.getNcasella());     
        if(currentPlayer==2)
            Imprevisti(player2, player2.getNcasella());  
        if(currentPlayer==3)
            Imprevisti(player3, player3.getNcasella());  
        if(currentPlayer==4)
            Imprevisti(player4, player4.getNcasella());  
        Imprevisti.setVisible(false);
    }//GEN-LAST:event_ImprevistiActionPerformed

    private void TerminaTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminaTurnoActionPerformed
        // TODO add your handling code here:
        Proprieta.setVisible(false);
        aggiornaSaldo();
        cambiaGiocatore(currentPlayer);
        Dadi.setVisible(true);
        LabelDadi1.setVisible(false);
        LabelDadi2.setVisible(false);
        
    }//GEN-LAST:event_TerminaTurnoActionPerformed

    private void BtnConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfermaActionPerformed
        // TODO add your handling code here:
        Tabellone.setVisible(true);
        Conferma.setVisible(false);
        Names.setVisible(false);
    }//GEN-LAST:event_BtnConfermaActionPerformed

    private void BtnIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIndietroActionPerformed
        // TODO add your handling code here:
        Conferma.setVisible(false);
    }//GEN-LAST:event_BtnIndietroActionPerformed

    private void BtnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificaActionPerformed
        // TODO add your handling code here:
        Conferma.setVisible(false);
        G1.setText("");
        G2.setText("");
        G3.setText("");
        G4.setText("");
    }//GEN-LAST:event_BtnModificaActionPerformed

    private void CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompraActionPerformed
        // TODO add your handling code here:
       Player player = null;
       int p = 0;
        if(currentPlayer==1){
                player = player1;
                p=1;
        }if(currentPlayer==2){
                player = player2;
                p=2;
        }if(currentPlayer==3){
                player = player3;
                p=3;
        }if(currentPlayer==4){
                player = player4;
                p=4;
        }
        
        if(caselle[player.getNcasella()] instanceof Proprieta){
           Proprieta proprietaSelezionata = (Proprieta) caselle[player.getNcasella()];
            controllaPossibilita(player, proprietaSelezionata.getCostoAcquisto());
            if(possibilita){
                proprietaSelezionata.setProprietario(p); 
                 player.setProprieta(proprietaSelezionata);
                 player.setOrdine(proprietaSelezionata);
                 player.setSaldo(player.getSaldo()-proprietaSelezionata.getCostoAcquisto());
                 proprietaSelezionata.setDisponibile(false);
                 player.setnProprieta(0);
                 inserisciImmProprieta(player);
            }
            if (haDueProprietaStessoGruppo(player, proprietaSelezionata.getGruppo())) {
                        proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*2);
                        for(int i=0; i<caselle.length; i++){
                            if(caselle[i] instanceof Proprieta && caselle[i] != proprietaSelezionata){
                                Proprieta pr = (Proprieta) caselle[i];
                                if(pr.getGruppo() == proprietaSelezionata.getGruppo())
                                    pr.setTassa(proprietaSelezionata.getTassaBase()*2);
                            }
                        }
                    }
        }
       
       
       
        if(caselle[player.getNcasella()] instanceof Societa){
           Societa societaSelezionata = (Societa) caselle[player.getNcasella()];
            controllaPossibilita(player, societaSelezionata.getPrezzo());
            if(possibilita){
                societaSelezionata.setProprietario(p); 
                player.setOrdine(societaSelezionata);
                player.setSocieta(societaSelezionata);
                player.setNSocieta(0);
                 player.setSaldo(player.getSaldo()-societaSelezionata.getPrezzo());
                 societaSelezionata.setDisponibile(false);
                 inserisciImmProprieta(player);
            }
            if(player.getNsocieta()==2){
                societaSelezionata.setTasse(societaSelezionata.getTasse()*2);
                for(int i=0; i<caselle.length; i++){
                            if(caselle[i] instanceof Societa && caselle[i]!=societaSelezionata){
                                Societa pr = (Societa) caselle[i];
                                    pr.setTasse(pr.getTasse()*2);
                                    System.out.println("" + pr.getTasse());
                            }
                        }
            }
        }
        
       Compra.setVisible(false);
    }//GEN-LAST:event_CompraActionPerformed

    private void PagaETerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagaETerminaActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        
        if(caselle[player.getNcasella()] instanceof Proprieta){
           Proprieta proprietaSelezionata = (Proprieta) caselle[player.getNcasella()];
            controllaPossibilita(player, proprietaSelezionata.getTassa());
            if(possibilita){
                if(proprietaSelezionata.getProprietario() == 1)
                    player1.setSaldo(player1.getSaldo()+proprietaSelezionata.getTassa()); 
                if(proprietaSelezionata.getProprietario() == 2)
                    player2.setSaldo(player2.getSaldo()+proprietaSelezionata.getTassa()); 
                if(proprietaSelezionata.getProprietario() == 3)
                    player3.setSaldo(player3.getSaldo()+proprietaSelezionata.getTassa());
                if(proprietaSelezionata.getProprietario() == 4)
                    player4.setSaldo(player4.getSaldo()+proprietaSelezionata.getTassa());
             
                 player.setSaldo(player.getSaldo()-proprietaSelezionata.getTassa());

            }
       }
        
       if(caselle[player.getNcasella()] instanceof Societa){
           Societa societaSelezionata = (Societa) caselle[player.getNcasella()];
           controllaPossibilita(player, societaSelezionata.getTasse());
           if(possibilita){
                if(societaSelezionata.getProprietario() == 1)
                    player1.setSaldo(player1.getSaldo()+societaSelezionata.getTasse()); 
                if(societaSelezionata.getProprietario() == 2)
                    player2.setSaldo(player2.getSaldo()+societaSelezionata.getTasse()); 
                if(societaSelezionata.getProprietario() == 3)
                    player3.setSaldo(player3.getSaldo()+societaSelezionata.getTasse());
                if(societaSelezionata.getProprietario() == 4)
                    player4.setSaldo(player4.getSaldo()+societaSelezionata.getTasse());
             player.setSaldo(player.getSaldo()-societaSelezionata.getTasse());
           }
       
       }
        Proprieta.setVisible(false);
        Dadi.setVisible(true);
        LabelDadi1.setVisible(false);
        LabelDadi2.setVisible(false);
        aggiornaSaldo();
        cambiaGiocatore(currentPlayer);
    }//GEN-LAST:event_PagaETerminaActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        // TODO add your handling code here:
        EsciDiPrigione.setVisible(false);
        
        cambiaGiocatore(currentPlayer);
    }//GEN-LAST:event_NoActionPerformed

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        // TODO add your handling code here:
        if(currentPlayer==1){
            player1.setEsciDiPrigione(false);
            player1.setSaltaTurno(0);
        }
        if(currentPlayer==2){
            player2.setEsciDiPrigione(false);
            player2.setSaltaTurno(0);
        }if(currentPlayer==3){
            player3.setEsciDiPrigione(false);
            player3.setSaltaTurno(0);
        }if(currentPlayer==4){
            player4.setEsciDiPrigione(false);
            player4.setSaltaTurno(0);
        }
    }//GEN-LAST:event_SiActionPerformed

    private void TerminaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminaPartitaActionPerformed
        // TODO add your handling code here:
        Dadi.setVisible(false);
        LabelDadi1.setVisible(false);
        LabelDadi2.setVisible(false);
        calcolaVittoria();
        PartitaTerminata.setVisible(true);
        W4.setText(nome1);
        SaldoW4.setText(tot1+"");
        W5.setText(nome2);
        SaldoW5.setText(tot2+"");
        if(nPlayer==3){
            W6.setText(nome3);
            SaldoW6.setText(tot3+"");
        }
        if(nPlayer==4){
            W6.setText(nome3);
            SaldoW6.setText(tot3+"");
            W7.setText(nome4);
            SaldoW7.setText(tot4+"");
        }
        
        Vincitore.setText(maxPatrimonio);
        System.out.println(maxPatrimonio);
        
    }//GEN-LAST:event_TerminaPartitaActionPerformed

    private void TerminaSconfittaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminaSconfittaActionPerformed
        // TODO add your handling code here:
        Tabellone.setVisible(false);
        setVisible(false);
        Proprieta.setVisible(false);
        ImmProp.setVisible(false);
        EsciDiPrigione.setVisible(false);
        Names.setVisible(true);
    }//GEN-LAST:event_TerminaSconfittaActionPerformed

    private void EsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsciActionPerformed
        // TODO add your handling code here:
        Tabellone.setVisible(false);
        setVisible(false);
        Proprieta.setVisible(false);
        ImmProp.setVisible(false);
        EsciDiPrigione.setVisible(false);
        Names.setVisible(true);
    }//GEN-LAST:event_EsciActionPerformed

    private void AnnullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnullaActionPerformed
        // TODO add your handling code here:
        PartitaTerminata.setVisible(false);
        Dadi.setVisible(true);
        LabelDadi1.setVisible(true);
        LabelDadi2.setVisible(true);
    }//GEN-LAST:event_AnnullaActionPerformed

    private void IpotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpotecaActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        
        if (caselle[player.getNcasella()] instanceof Proprieta) {
            Proprieta proprietaSelezionata = (Proprieta) caselle[player.getNcasella()];
            player.setnProprieta(1);  // Riduce il numero di proprietà di 1
            proprietaSelezionata.setDisponibile(true);
            player.setSaldo(player.getSaldo() + proprietaSelezionata.getPzIpoteca());
            
            int l;
            for  (l = 0; l < player.getNproprieta()+player.getnSocieta(); l++) {
                Casella prop = player.getOrdine()[l];
                if (prop != null && prop.getNome().equals(proprietaSelezionata.getNome())) {
                    player.togliOrdine(l);
                    break;  // Esci dal ciclo una volta trovata e rimossa la proprietà
                }
            }
            
            eliminaImmagini(l);
        }
        
        if (caselle[player.getNcasella()] instanceof Societa) {
            Societa proprietaSelezionata = (Societa) caselle[player.getNcasella()];
            player.setnSocieta(1);  // Riduce il numero di proprietà di 1
            proprietaSelezionata.setDisponibile(true);
            player.setSaldo(player.getSaldo() + proprietaSelezionata.getIpoteca());
            
            int l;
            for  (l = 0; l < player.getNproprieta()+player.getnSocieta(); l++) {
                Casella prop = player.getOrdine()[l];
                if (prop != null && prop.getNome().equals(proprietaSelezionata.getNome())) {
                    player.togliOrdine(l);
                    break;  // Esci dal ciclo una volta trovata e rimossa la proprietà
                }
            }
            
            
            eliminaImmagini(l);
        }
    }//GEN-LAST:event_IpotecaActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        // TODO add your handling code here:
        Setting.setVisible(false);
    }//GEN-LAST:event_XActionPerformed

    private void MusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusicaActionPerformed
        // TODO add your handling code here:
        if(!Line.isVisible()){
            stopSong();
            Line.setVisible(true);
        }else{
            canzonebase();
            Line.setVisible(false);
        }
    }//GEN-LAST:event_MusicaActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported()) {
            try {
                String filePath = "C:\\Users\\Niccolo'\\Desktop\\Monopoli\\Manuale Utente Monopoli.pdf";
                File pdfFile = new File(filePath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Il file non esiste");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Desktop non supportato");
        }
    }//GEN-LAST:event_InfoActionPerformed

    private void SettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettActionPerformed
        // TODO add your handling code here:
        Setting.setVisible(true);
    }//GEN-LAST:event_SettActionPerformed

    private void CostruisciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostruisciActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        
        if(caselle[player.getNcasella()] instanceof Proprieta){
            Proprieta proprietaSelezionata = (Proprieta) caselle[player.getNcasella()];
            controllaPossibilita(player, proprietaSelezionata.getCostoCasa());
            if(possibilita){
                player.setSaldo(player.getSaldo()-proprietaSelezionata.getCostoCasa());
                if(proprietaSelezionata.getnCase()+1>5){
                    Case.setVisible(true);
                    jLabel21.setText(proprietaSelezionata.getNome());
                }else{
                    proprietaSelezionata.setnCase();
                    Costruisci.setVisible(false);
                }
                ImageIcon icon = null;
                if(proprietaSelezionata.getnCase() == 1){
                    icon = new ImageIcon("casa1.png");
                    proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*3);
                }if(proprietaSelezionata.getnCase() == 2){
                    icon = new ImageIcon("casa2.png");
                    proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*4);
                }if(proprietaSelezionata.getnCase() == 3){
                    icon = new ImageIcon("casa3.png");
                    proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*5);
                }if(proprietaSelezionata.getnCase() == 4){
                    icon = new ImageIcon("casa4.png");
                    proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*6);
                }if(proprietaSelezionata.getnCase() == 5){
                    icon = new ImageIcon("albergo.png");
                    proprietaSelezionata.setTassa(proprietaSelezionata.getTassaBase()*7);
                }
                switch (player.getNcasella()){
                    case 1: Casa1.setIcon(icon);
                        break;
                    case 3: Casa2.setIcon(icon);
                        break;
                    case 5: Casa3.setIcon(icon);
                        break;
                    case 7: Casa4.setIcon(icon);
                        break;
                    case 9: Casa5.setIcon(icon);
                        break;
                    case 10: Casa6.setIcon(icon);
                        break;
                    case 13: Casa7.setIcon(icon);
                        break;
                    case 15: Casa8.setIcon(icon);
                        break;
                    case 17: Casa9.setIcon(icon);
                        break;
                    case 18: Casa10.setIcon(icon);
                        break;
                    case 20: Casa11.setIcon(icon);
                        break;
                    case 22: Casa12.setIcon(icon);
                        break;
                    case 25: Casa13.setIcon(icon);
                        break;
                    case 27: Casa14.setIcon(icon);
                        break;
                    case 29: Casa15.setIcon(icon);
                        break;
                    case 31: Casa16.setIcon(icon);
                        break;
                    default:
               }
            }
        }
    }//GEN-LAST:event_CostruisciActionPerformed

    private void TerminaTurno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminaTurno1ActionPerformed
        // TODO add your handling code here:
        Possibilità.setVisible(false);
        Proprieta.setVisible(false);
        cambiaGiocatore(currentPlayer);
    }//GEN-LAST:event_TerminaTurno1ActionPerformed

    private void I5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I5ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(4, player);
        
    }//GEN-LAST:event_I5ActionPerformed

    private void I1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I1ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(0, player);
        
    }//GEN-LAST:event_I1ActionPerformed

    private void I4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I4ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(3, player);
    }//GEN-LAST:event_I4ActionPerformed

    private void I2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I2ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(1, player);
    }//GEN-LAST:event_I2ActionPerformed

    private void I6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I6ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(5, player);
    }//GEN-LAST:event_I6ActionPerformed

    private void I3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I3ActionPerformed
        // TODO add your handling code here:
        Player player = null;
        if(currentPlayer==1)
                player = player1;
        if(currentPlayer==2)
                player = player2;
        if(currentPlayer==3)
                player = player3;
        if(currentPlayer==4)
                player = player4;
        
        ipoteca(2, player);
    }//GEN-LAST:event_I3ActionPerformed

    private void TerminaTurno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminaTurno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TerminaTurno2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabellone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabellone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabellone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabellone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabellone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annulla;
    private javax.swing.JButton BtnConferma;
    private javax.swing.JButton BtnIndietro;
    private javax.swing.JButton BtnModifica;
    private javax.swing.JLabel Casa1;
    private javax.swing.JLabel Casa10;
    private javax.swing.JLabel Casa11;
    private javax.swing.JLabel Casa12;
    private javax.swing.JLabel Casa13;
    private javax.swing.JLabel Casa14;
    private javax.swing.JLabel Casa15;
    private javax.swing.JLabel Casa16;
    private javax.swing.JLabel Casa2;
    private javax.swing.JLabel Casa3;
    private javax.swing.JLabel Casa4;
    private javax.swing.JLabel Casa5;
    private javax.swing.JLabel Casa6;
    private javax.swing.JLabel Casa7;
    private javax.swing.JLabel Casa8;
    private javax.swing.JLabel Casa9;
    private javax.swing.JPanel Case;
    private javax.swing.JLabel Citta;
    private javax.swing.JButton Compra;
    private javax.swing.JPanel Conferma;
    private javax.swing.JButton Costruisci;
    private javax.swing.JButton Dadi;
    private javax.swing.JButton Esci;
    private javax.swing.JPanel EsciDiPrigione;
    private javax.swing.JLabel G1;
    private javax.swing.JLabel G11;
    private javax.swing.JLabel G12;
    private javax.swing.JLabel G13;
    private javax.swing.JLabel G14;
    private javax.swing.JLabel G15;
    private javax.swing.JLabel G16;
    private javax.swing.JLabel G2;
    private javax.swing.JLabel G21;
    private javax.swing.JLabel G22;
    private javax.swing.JLabel G23;
    private javax.swing.JLabel G24;
    private javax.swing.JLabel G25;
    private javax.swing.JLabel G26;
    private javax.swing.JLabel G3;
    private javax.swing.JLabel G31;
    private javax.swing.JLabel G32;
    private javax.swing.JLabel G33;
    private javax.swing.JLabel G34;
    private javax.swing.JLabel G35;
    private javax.swing.JLabel G36;
    private javax.swing.JLabel G4;
    private javax.swing.JLabel G41;
    private javax.swing.JLabel G42;
    private javax.swing.JLabel G43;
    private javax.swing.JLabel G44;
    private javax.swing.JLabel G45;
    private javax.swing.JLabel G46;
    private javax.swing.JButton Gioca;
    private javax.swing.JButton I1;
    private javax.swing.JButton I2;
    private javax.swing.JButton I3;
    private javax.swing.JButton I4;
    private javax.swing.JButton I5;
    private javax.swing.JButton I6;
    private javax.swing.JLabel ImmProp;
    private javax.swing.JPanel ImpProb;
    private javax.swing.JButton Imprevisti;
    private javax.swing.JButton Info;
    private javax.swing.JButton Ipoteca;
    private javax.swing.JPanel IpotecaPr;
    private javax.swing.JLabel LabelDadi1;
    private javax.swing.JLabel LabelDadi2;
    private javax.swing.JLabel Line;
    private javax.swing.JButton Musica;
    private javax.swing.JPanel Names;
    private javax.swing.JButton No;
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel Nome2;
    private javax.swing.JLabel Nome3;
    private javax.swing.JLabel Nome4;
    private javax.swing.JLabel NomeSconfitta;
    private javax.swing.JLabel NomeVittoria;
    private javax.swing.JButton OkImpProb;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel P4;
    private javax.swing.JButton PagaETermina;
    private javax.swing.JPanel PartitaFinita;
    private javax.swing.JPanel PartitaTerminata;
    private javax.swing.JLabel Pedina0;
    private javax.swing.JLabel Pedina1;
    private javax.swing.JLabel Pedina10;
    private javax.swing.JLabel Pedina11;
    private javax.swing.JLabel Pedina12;
    private javax.swing.JLabel Pedina13;
    private javax.swing.JLabel Pedina14;
    private javax.swing.JLabel Pedina15;
    private javax.swing.JLabel Pedina16;
    private javax.swing.JLabel Pedina17;
    private javax.swing.JLabel Pedina18;
    private javax.swing.JLabel Pedina19;
    private javax.swing.JLabel Pedina2;
    private javax.swing.JLabel Pedina20;
    private javax.swing.JLabel Pedina21;
    private javax.swing.JLabel Pedina22;
    private javax.swing.JLabel Pedina23;
    private javax.swing.JLabel Pedina24;
    private javax.swing.JLabel Pedina25;
    private javax.swing.JLabel Pedina26;
    private javax.swing.JLabel Pedina27;
    private javax.swing.JLabel Pedina28;
    private javax.swing.JLabel Pedina29;
    private javax.swing.JLabel Pedina3;
    private javax.swing.JLabel Pedina30;
    private javax.swing.JLabel Pedina31;
    private javax.swing.JLabel Pedina4;
    private javax.swing.JLabel Pedina5;
    private javax.swing.JLabel Pedina6;
    private javax.swing.JLabel Pedina7;
    private javax.swing.JLabel Pedina8;
    private javax.swing.JLabel Pedina9;
    private javax.swing.JTextField Player1;
    private javax.swing.JTextField Player2;
    private javax.swing.JTextField Player3;
    private javax.swing.JTextField Player4;
    private javax.swing.JPanel Possibilità;
    private javax.swing.JPanel Proprieta;
    private javax.swing.JLabel Saldo1;
    private javax.swing.JLabel Saldo2;
    private javax.swing.JLabel Saldo3;
    private javax.swing.JLabel Saldo4;
    private javax.swing.JLabel SaldoW1;
    private javax.swing.JLabel SaldoW2;
    private javax.swing.JLabel SaldoW3;
    private javax.swing.JLabel SaldoW4;
    private javax.swing.JLabel SaldoW5;
    private javax.swing.JLabel SaldoW6;
    private javax.swing.JLabel SaldoW7;
    private javax.swing.JButton Sett;
    private javax.swing.JPanel Setting;
    private javax.swing.JButton Si;
    private javax.swing.JPanel Tabellone;
    private javax.swing.JButton TerminaPartita;
    private javax.swing.JButton TerminaSconfitta;
    private javax.swing.JButton TerminaTurno;
    private javax.swing.JButton TerminaTurno1;
    private javax.swing.JButton TerminaTurno2;
    private javax.swing.JLabel Turno;
    private javax.swing.JLabel Vincitore;
    private javax.swing.JLabel W1;
    private javax.swing.JLabel W2;
    private javax.swing.JLabel W3;
    private javax.swing.JLabel W4;
    private javax.swing.JLabel W5;
    private javax.swing.JLabel W6;
    private javax.swing.JLabel W7;
    private javax.swing.JButton X;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
