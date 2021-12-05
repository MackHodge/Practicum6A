package Practicum6A;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Game {

    private String naam;
    private int huidigJaar ;

    private double discoutPrijs;
    private double nieuwprijs;

    private String pattern = "0.00";
    private DecimalFormat decimalFormat = new DecimalFormat(pattern);

    final private int  releaseJaar;

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

    @Override
    public String toString() {
        String s = ""+naam+", uitgegeven in "+releaseJaar +"; nieuwprijs: €"+decimalFormat.format(nieuwprijs)+" nu voor: €"+decimalFormat.format( huidigeWaarde())+"";
        return s;
    }
}
