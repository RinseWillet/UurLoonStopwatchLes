import java.time.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class uurLoonStopwatch {

//********** Stap 7 - Nu willen we dingen gaan invoeren en op de lijst krijgen EN we willen de tijdsmeting koppelen aan
//* 			het uurloon, zodat we kunnen zien hoeveel we per taak verdiend hebben
//		--------------------------------------------------
//    String activiteit = activiteitVeld.getText();
//        System.out.println(activiteit);
//        ----------------------------------------------
//    run en nu zie je dat je invoer in de console verschijnt. Dan is het nu zaak het Uurloon ook hier te krijgen
//    en te zorgen dat het in een rekenbaar type komt, in dit geval een double
//        ------------------------------------------------
//    String brutoUurloon = uurLoon.getText();
//    double loon = Double.parseDouble(brutoUurloon);
//		------------------------------------------------
//    nu willen we zorgen dat deze informatie in het Textarea verschijnt en dit doen we daar de textArea aan te roepen
//    en daar de text in te plaatsen met setText
//		---------------------------------------------------
//                textArea.setText(activiteit + " met een uurloon van " + brutoUurloon + "\n");
//		---------------------------------------------------
//    je ziet nu dat het vorige item steeds weggehaald wordt, en dat willen we niet, dus daarom voegen we dit toe:
//            ----------------------------------------------------
//            textArea.setText(textArea.getText() + activiteit + " met een uurloon van " + brutoUurloon + "\n");
//		----------------------------------------------------
//    We hebben nu in de terminal al de tijdmeting staan (zegmaar de duur per taak) en die willen we ook per taak laten zien
//		----------------------------------------------------
//                textArea.setText(textArea.getText() + activiteit + " met een uurloon van " + loon + " : " + tijdsVerschil.getSeconds() + " seconden " + "\n");
//		----------------------------------------------------
//    nu wil je nog zien hoeveel je per taak hebt verdiend en dat doe je door het uurloon om te rekenen naar loon per seconden
//    en dan te vermenigvuldigen met het gemeten aantal seconden.
//		---------------------------------------------------
//                lijst.setText(lijst.getText() + activiteit + " met een uurloon van " + loon + " : " + tijdsVerschil.getSeconds() + " seconden gewerkt en " + ((loon/3600) * tijdsVerschil.getSeconds()) + " verdiend\n");
//		---------------------------------------------------
//    nu heb je wel heel veel getallen achter de komma, dat kan wel wat mooier
//		---------------------------------------------------
//                import java.text.DecimalFormat;
//    private static DecimalFormat df = new DecimalFormat("0.00");
//
//    long aantalSeconden = tijdsVerschil.getSeconds();
//    String verdiendText = df.format((loon/3600) * aantalSeconden);
//
//		lijst.setText(lijst.getText() + activiteit + " met een uurloon van " + loon + " : " + aantalSeconden + " seconden gewerkt en " + verdiendText + " verdiend\n");
//		----------------------------------------------------------

    private static DecimalFormat df = new DecimalFormat("0.00");

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

            lijst.setText(lijst.getText() + activiteit + " met een uurloon van " + loon + " : " + aantalSeconden + " seconden gewerkt en " + verdiendText + " verdiend\n");

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

