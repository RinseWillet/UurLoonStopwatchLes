import java.time.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class uurLoonStopwatch {

    // Formatting doubles en variabele totaal verdiend
    private static DecimalFormat df = new DecimalFormat("0.00");
    static double totaalVerdiend = 0;

    public static void main (String[] args){

        //tijdsmeting object aanmaken
        tijdsMeting klok = new tijdsMeting();

        //aanmaken kader, knop, velden en labels
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

        //gedrag knop instellen
        knop.addActionListener(e -> {
            String activiteit = activiteitVeld.getText();

            String brutoUurloon = uurLoon.getText();
            double loon = Double.parseDouble(brutoUurloon);

            klok.eind = LocalDateTime.now();
            Duration tijdsVerschil = Duration.between(klok.start, klok.eind);
            klok.start = klok.eind;

            long aantalSeconden = tijdsVerschil.getSeconds();
            String verdiendText = df.format((loon/3600) * aantalSeconden);

            totaalVerdiend = totaalVerdiend + ((loon/3600) * aantalSeconden);

            lijst.setText(lijst.getText() + activiteit + " met een uurloon van " + loon + " : " + aantalSeconden + " seconden gewerkt en " + verdiendText + " verdiend\n");

            totaal.setText(df.format(totaalVerdiend) + " Euro verdiend!" );
        });

        // het kader invullen met de velden
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
    }
}

class tijdsMeting {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime eind;
}

