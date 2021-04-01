import java.time.*;
import javax.swing.*;

public class uurLoonStopwatch {

//*********** Stap 6 Velden bouwen om de Activiteit en het Uurloon in te vullen
//    We gaan nu gebruik maken van een Swing Textfields om een veld te maken voor:
//      * de activiteit
//		* het uurloon
//		* een outputveld waar de taken komen te staan
//		* ook geven we alle velden labels
//		----------------------------------------
//    JTextField activiteitVeld = new JTextField();
//		activiteitVeld.setBounds(30,150,100, 40);
//
//		kader.add(activiteitVeld);
//		------------------------------------------
//    nu draaien en dan zien we het veld
//		------------------------------------------
//    JTextField uurLoon = new JTextField(10);
//		uurLoon.setBounds(30,200,100, 40);
//
//		kader.add(uurLoon);
//		-------------------------------------------
//    nu draaien en dan zien we het tweede veld eronder.
//    Nu willen we een tekstblok maken waarin we de lijst maken van de taken en
//    de hoeveelheid seconden.
//		-------------------------------------------
//    JTextArea textArea = new JTextArea(50, 200);
//		textArea.setBounds(30, 250, 700, 200);
//
//		kader.add(textArea);
//		-------------------------------------------
//    nu draaien en dan zien we een tekstarea eronder. Nu zouden wat labels nog wel heel handig zijn
//		----------------------------------------------
//    JLabel activiteitLabel = new JLabel("Voer hier de activiteit in");
//		activiteitLabel.setBounds(150,150,200,40);
//
//		kader.add(activiteitLabel);
//		----------------------------------------------
//    en nu nog voor het uurloon
//		----------------------------------------------
//    JLabel uurLoonLabel = new JLabel("Voer hier het uurloon in met een . ");
//		uurLoonLabel.setBounds(150,200,200,40);
//
//		kader.add(uurLoonLabel)
//            ------------------------------------------------
//    en dan hebben we nu de velden in onze GUI uiteengezet


    public static void main (String[] args){

        tijdsMeting klok = new tijdsMeting();

        JFrame kader = new JFrame();

        JButton knop=new JButton("Tijd opnemen");
        knop.setBounds(30,100,120, 40);

        JTextField activiteitVeld = new JTextField();
		activiteitVeld.setBounds(30,150,100, 40);

        JTextField uurLoon = new JTextField(10);
		uurLoon.setBounds(30,200,100, 40);

        JTextArea lijst = new JTextArea(50, 200);
		lijst.setBounds(30, 250, 700, 200);

        JLabel activiteitLabel = new JLabel("Voer hier de activiteit in");
		activiteitLabel.setBounds(150,150,200,40);

        JLabel uurLoonLabel = new JLabel("Voer hier het uurloon in met een . ");
    	uurLoonLabel.setBounds(150,200,200,40);

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
        kader.add(activiteitVeld);
        kader.add(uurLoon);
        kader.add(lijst);
        kader.add(activiteitLabel);
        kader.add(uurLoonLabel);
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

