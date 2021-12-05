package Practicum6A;

import java.time.LocalDate;

public class Game {

    private String naam;
    private int huidigJaar ;
    final private int  releaseJaar;
    private double discoutPrijs;
    private double nieuwprijs;

    public Game(String Title, int ReleaseJaar, double Prijs) {
            naam = Title;
            releaseJaar = ReleaseJaar;
            nieuwprijs = Prijs;
            huidigJaar = LocalDate.now().getYear();
    }

    public String getNaam() {
        return naam;
    }

    public int getReleaseJaar() {
        return releaseJaar;
    }

    public double getDiscoutPrijs() {
        return discoutPrijs;
    }

    public int getHuidigJaar() {
        return huidigJaar;
    }



    public double getNieuwprijs() {
        return nieuwprijs;
    }

    public double huidigeWaarde (){
        double t;
        return t = (releaseJaar != huidigJaar)? discoutPrijs = nieuwprijs - (nieuwprijs *0.30) : nieuwprijs;


    }


}
