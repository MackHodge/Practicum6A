package Practicum6B;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Persoon {
    private String name ;
    private double budget;

    private ArrayList<Game> mijnGames = new ArrayList();

    private String pattern = "0.00";
    private DecimalFormat decimalFormat = new DecimalFormat(pattern);

    public Persoon(String Name, double bud) {
        this.name = Name;
        this.budget = bud;
    }

    public ArrayList<Game> getMijnGames() {
        return mijnGames;
    }

    public double getBudget() {
        return budget;
    }

    /**
     * If person budget is les than the game price && and if i dont already
     * own the game return true or the game is the same true
     * @param g game object
     * @return true if enough funds and the game does not exist
     */
    public boolean koop(Game g) {
        boolean t ;
        if (g != null && this.budget > g.huidigeWaarde() && !mijnGames.contains(g) ) {
            this.budget -= g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        }
        return false;
    }

    /**
     * If game is not owned verkoop returns true
     * @param gameToSell
     * @param koper
     * @return
     */

    public boolean verkoop(Game gameToSell, Persoon koper) {

        if(mijnGames.contains(gameToSell) && koper.koop(gameToSell)) {
            mijnGames.remove(gameToSell);
            budget += gameToSell.huidigeWaarde();
            return true;
        }
        return false;

    }

    //
    private String printArrayListItems(){
        String t = "";
        for (Game game:mijnGames) {
            t += "\n"+ game.toString();
        }
        return t ;
    }

    public Game zoekGameOpNaam(String gameToSearchFor) {
        for (int i = 0 ; i < mijnGames.size() ; i++)
        {
            if(mijnGames.get(i).getNaam().equals(gameToSearchFor)) {
                return  mijnGames.get(i) ;
            }
        }
        return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> teKoop) {
        ArrayList<Game> nogNietInBezit = new ArrayList<Game>();
        for (Game a: teKoop) {
            if(!mijnGames.contains(a)){
                nogNietInBezit.add(a);
            }
        }
        return nogNietInBezit;
    }



    @Override
    public String toString() {
        String s = ""+this.name +" heeft een budget van €" +decimalFormat.format(this.budget)+" en bezit de volgende games:"+printArrayListItems()+"";

        return s;
    }
}
