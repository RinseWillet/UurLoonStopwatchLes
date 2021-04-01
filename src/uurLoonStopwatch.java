import java.time.*;
import javax.swing.*;

public class uurLoonStopwatch {

//************ Stap 5 Knop gaan bouwen om een tijdsmeting te doen
//		------------------------------------
//    JButton knop=new JButton("Tijd opnemen");
//		knop.setBounds(30,100,120, 40);
//
//		kader.add(knop)
//
//            ------------------------------------
//    en dan een eventlistener toevoegen aan de knop (zodat ie ook wat gaat doen zodra er geklikt wordt
//            ---------------------------------
//            knop.addActionListener(e ->
//    {
//        System.out.println("knop gedrukt");
//    });
//		-----------------------------------
//    en dan moeten we gebruik gaan maken van de tijd en daar een meting van maken
//		-----------------------------------
//    klok.eind = LocalDateTime.now();
//    Duration tijdsVerschil = Duration.between(klok.start, klok.eind);
//        System.out.println("Het verschil is : " + tijdsVerschil);
//        -------------------------------------
//    je ziet dat de tijd blijft oplopen en het verschil groter wordt, en dat komt doordat het beginpunt (klok.start)
//    nog steeds hetzelfde blijft. We zullen die dus moeten herïnitialiseren:
//            -----------------------------------
//    klok.start = klok.eind;
//        ----------------------------------
//    we hebben nu dus een knop die een tijdsmeting start en de periode meet tussen dat je op de knop gedrukt hebt


    public static void main (String[] args){

        tijdsMeting klok = new tijdsMeting();

        JFrame kader = new JFrame();

        JButton knop=new JButton("Tijd opnemen");
        knop.setBounds(30,100,120, 40);

        knop.addActionListener(e -> {
        System.out.println("knop gedrukt");
        klok.eind = LocalDateTime.now();
        Duration tijdsVerschil = Duration.between(klok.start, klok.eind);
        System.out.println("Het verschil is : " + tijdsVerschil);
        klok.start = klok.eind;
        });


        System.out.println(klok.start);
        System.out.println(klok.eind);

        kader.add(knop);
        kader.setSize(1000,600);
        kader.setLayout(null);
        kader.setVisible(true);

///SCRIBBLES
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

