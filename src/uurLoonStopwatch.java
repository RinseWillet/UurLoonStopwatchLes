import java.time.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class uurLoonStopwatch {

//*********** Stap 8 Totaalverdiend toevoegen
//    nu is het wat netter. Als allerlaatste willen we natuurlijk ook een idee hebben van hoeveel we nu in totaal
//    verdiend hebben, dus daar voegen we een textfield toe onder de text area, met ook een label:
//            ------------------------------------------------------------------
//    JLabel totaalLabel = new JLabel("Totaal verdiend: ");
//		totaalLabel.setBounds(30,460,100,40);
//
//    JTextField totaal = new JTextField(20);
//		totaal.setBounds(150, 460, 300, 40);
//
//		kader.add(totaalLabel);
//		kader.add(totaal);
//		---------------------------------------------------------------
//    nu draaien en dan zie je het veld en de label verschijnen. Nu willen we nog een variabele maken waarin
//    het totaal verdiende bedrag wordt bijgehouden:
//            ---------------------------------------------------------------
//    static double totaalVerdiend = 0;
//		--------------------------------------------------------------
//    nu willen we iedere keer het verdiende loon gaan optellen bij deze variabele
//		--------------------------------------------------------------
//    totaalVerdiend = totaalVerdiend + ((loon/3600) * aantalSeconden);
//		--------------------------------------------------------------
//    Let op: we hebben hier dus opnieuw het Loon uitgerekend, maar omdat de eerdere lijn hem via die formatter in
//    een String dwingt, moeten we nog eens uitrekeken. Alternatief is de string te parsen als een double:
//            -----------------------------------------------------------------
//    totaalVerdiend = totaalVerdiend + Double.parseDouble(verdiendText);
//		-----------------------------------------------------------------
//    het allerlaastste wat we nu moeten doen is deze variabelen aan het TextField gaan toewijzen onderaan:
//            -------------------------------------------------------------------
//            totaal.setText(df.format(totaalVerdiend) + " Euro verdiend!" );
//		-------------------------------------------------------------------
//    Draaien en klaar, dank voor de aandacht :-)
//            - Challenges:
//            - maak een reset-knop
//			- zet dit om naar JavaFX of naar een FrontEnd
//			- zorg dat er weekend-toeslagen berekend worden
//
//	 */

    private static DecimalFormat df = new DecimalFormat("0.00");
    static double totaalVerdiend = 0;

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


        JLabel totaalLabel = new JLabel("Totaal verdiend: ");
        totaalLabel.setBounds(30,460,100,40);

        JTextField totaal = new JTextField(20);
        totaal.setBounds(150, 460, 300, 40);

        knop.addActionListener(e -> {
            String activiteit = activiteitVeld.getText();
            System.out.println(activiteit);

            String brutoUurloon = uurLoon.getText();
            double loon = Double.parseDouble(brutoUurloon);

            System.out.println("knop gedrukt");
            klok.eind = LocalDateTime.now();
            Duration tijdsVerschil = Duration.between(klok.start, klok.eind);
            System.out.println("Het verschil is : " + tijdsVerschil);
            klok.start = klok.eind;

            long aantalSeconden = tijdsVerschil.getSeconds();
            String verdiendText = df.format((loon/3600) * aantalSeconden);

            totaalVerdiend = totaalVerdiend + ((loon/3600) * aantalSeconden);
            //of
            // totaalVerdiend = totaalVerdiend + Double.parseDouble(verdiendText);

            lijst.setText(lijst.getText() + activiteit + " met een uurloon van " + loon + " : " + aantalSeconden + " seconden gewerkt en " + verdiendText + " verdiend\n");

            totaal.setText(df.format(totaalVerdiend) + " Euro verdiend!" );
        });


        System.out.println(klok.start);
        System.out.println(klok.eind);

        kader.add(knop);
        kader.add(activiteitVeld);
        kader.add(uurLoon);
        kader.add(lijst);
        kader.add(activiteitLabel);
        kader.add(uurLoonLabel);
        kader.add(totaalLabel);
        kader.add(totaal);
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

