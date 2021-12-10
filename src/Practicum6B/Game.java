package Practicum6B;

import java.time.LocalDate;

public class Game {

    private String naam;
    final private int  releaseJaar;
    private double nieuwprijs;

    private int huidigJaar ;

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

    public int getHuidigJaar() {
        return huidigJaar;
    }

    public double getNieuwprijs() {
        return nieuwprijs;
    }

    public double huidigeWaarde (){

        int verschilInJaar = huidigJaar - releaseJaar ;
        return nieuwprijs * (Math.pow(0.70 ,verschilInJaar));

    }

    @Override
    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;
        if(andereObject instanceof Game){
            Game andereGame = (Game) andereObject;
            if(this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    @Override
    public String toString() {
        return ""+naam + ", uitgegeven in "+ releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde())+"";
    }
}
