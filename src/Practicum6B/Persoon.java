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

    private boolean doesGameExist(Game game){
        for (var g: mijnGames) {
            if(g.getNaam().contains(game.getNaam()) && g.getReleaseJaar() == game.getReleaseJaar()){
                return false;
            }
        }
        return true;
    }

    /**
     * If person budget is les than game price return or the game is the same true
     * @param g game object
     * @return true if enough funds and the game does not exist
     */
    public boolean koop(Game g) {
        boolean t ;
        if (g != null && this.budget > g.huidigeWaarde() && doesGameExist(g)) {
                this.budget -= g.huidigeWaarde();
                mijnGames.add(g);
                return true;
        }
        return false;
    }

    public double getBudget() {
        return budget;
    }

    /**
     * If game is not owned verkoop returns true
     * @param gameToSell
     * @param koper
     * @return
     */

    public boolean verkoop(Game gameToSell, Persoon koper) {
        //look in mijnGames for the game I am trying to sell
        //Who wants to buy the game ?
        //Does he have enough money to buy
        for (var gameInList :mijnGames) {
            if(gameInList.getNaam().contains(gameToSell.getNaam()) && koper.budget >= gameInList.getDiscoutPrijs()) {
                koper.budget -= gameInList.getDiscoutPrijs();
                koper.mijnGames.add(gameToSell);
                mijnGames.remove(gameToSell);
                budget += gameInList.getDiscoutPrijs();
                return true;
            }
        }
        return false;

    }

    private String printArrayListItems(){
        String t = " " ;
        for (int i = 0 ; i < mijnGames.size();i++){
            t += (mijnGames != null) ?
           " "+mijnGames.get(i).getNaam()+ " uitgegeven in " +mijnGames.get(i).getReleaseJaar()+"; nieuwprijs: €"+mijnGames.get(i).getNieuwprijs() +" nu voor: €"
                   +decimalFormat.format(mijnGames.get(i).getDiscoutPrijs())+"\n" :"null" ;
        }
          return t ;
        }

    @Override
    public String toString() {
        String s = ""+this.name +" heeft een budget van " +decimalFormat.format(this.budget)+" en bezit de volgende games:"+ printArrayListItems()+"" ,t =" ";

        return s;
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
}
