import java.time.*;

public class uurLoonStopwatch {

// ********** Stap 3 Beginnen met het opzetten van een class Tijdsmeting waar we het tijdsmeten gaan doen
//        -------------------------------------------------
//
//
//        System.out.println(klok.eind);     -----> null, want die is enkel gedeclareerd en nog niet ingevuld.
//	 LET OP HET TIJDSVERSCHIL TUSSEN DIRECT AANROEPEN EN VIA HET TIJDSMETING OBJECT
//
//


    public static void main (String[] args){


        System.out.println("Klaar voor de start");
        LocalTime tijdStip1 = LocalTime.of(8,5,10);
        LocalTime tijdStip2 = LocalTime.of(19,3,00);
        Duration tijdsVerschil = Duration.between(tijdStip1, tijdStip2);

        System.out.println("het tijdsverschil is : " + tijdsVerschil);

        //  PT -> P staat voor period (datum) en T voor Time


        //  en daarna over langere tijden:

        LocalDateTime tijdStip3 = LocalDateTime.of(2020,10,1,8,5,00);
        LocalDateTime tijdStip4 = LocalDateTime.of(2021,1,18,8,10,00);
        Duration tijdsVerschil2 = Duration.between(tijdStip3,tijdStip4);
        long tijdsVerschil3 = tijdsVerschil2.toDays();

        System.out.println("het tweede tijdsverschil is : " + tijdsVerschil2);
        System.out.println("het tijdsverschil in dagen in : " + tijdsVerschil3);

        System.out.println(LocalDateTime.now()); ////tijdstip direct aangeroepen
        tijdsMeting klok = new tijdsMeting();
        System.out.println(klok.start);
        System.out.println(klok.eind);
    }
}

class tijdsMeting {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime eind;
}

