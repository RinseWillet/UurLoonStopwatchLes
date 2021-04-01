import java.time.*;

public class uurLoonStopwatch {

//    Stap 2 - tijd is dus heel belangrijk in deze, dus we beginnen met de LocalDate en LocatDateTime functie
//	- laten zien docs
//	- laten zien: import java.time.LocalDateTime;
//	- laten zien: System.out.println(LocalDateTime.now());
//
//    Om tijdsduur tussen twee tijdstippen te berekenen heb je een Duration nodig
//
//	- laten zien: Duration - docs
//	- laten zien: import java.time.Duration -> class om lengte tussen twee tijdstippen te berekenen - vooral geschikt voor kortere tijdspannes
//    Period bestaat ook, maar die is eerder bedoeld om aantal dagen, maanden en jaren te berekenen
//
//    voorbeeld met LocalTime :

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
    }
}
