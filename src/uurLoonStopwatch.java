import java.time.*;
import javax.swing.*;

public class uurLoonStopwatch {

//***********        Stap 4 In deze stap willen we Swing gaan opbouwen
//        - Uitleggen dat Swing een gedateerde API van Oracle is die je in staat stelt een
//    Graphical User Interface te maken voor je Java programma. Iets moderner is JavaFX
//            (maar dat wordt niet ondersteund nog door Repl.It en vereist wat installeerwerk op je IDE)
//        - Veel moderner is het je Java programma aan een frontend in JS, html, Css te hangen, maar dat kost teveel tijd voor hier
//        - beginnen met het opzetten van een frame
//     
//		----------------------------------

    public static void main (String[] args){
        JFrame kader = new JFrame();

        tijdsMeting klok = new tijdsMeting();
        System.out.println(klok.start);
        System.out.println(klok.eind);

        kader.setSize(1000,600);
        kader.setLayout(null);
        kader.setVisible(true);


//        System.out.println("Klaar voor de start");
//        LocalTime tijdStip1 = LocalTime.of(8,5,10);
//        LocalTime tijdStip2 = LocalTime.of(19,3,00);
//        Duration tijdsVerschil = Duration.between(tijdStip1, tijdStip2);
//
//        System.out.println("het tijdsverschil is : " + tijdsVerschil);
//
//        //  PT -> P staat voor period (datum) en T voor Time
//
//
//        //  en daarna over langere tijden:
//
//        LocalDateTime tijdStip3 = LocalDateTime.of(2020,10,1,8,5,00);
//        LocalDateTime tijdStip4 = LocalDateTime.of(2021,1,18,8,10,00);
//        Duration tijdsVerschil2 = Duration.between(tijdStip3,tijdStip4);
//        long tijdsVerschil3 = tijdsVerschil2.toDays();
//
//        System.out.println("het tweede tijdsverschil is : " + tijdsVerschil2);
//        System.out.println("het tijdsverschil in dagen in : " + tijdsVerschil3);
//
//        System.out.println(LocalDateTime.now()); ////tijdstip direct aangeroepen

    }
}

class tijdsMeting {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime eind;
}

