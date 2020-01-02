package uoc.ded.practica.model;


import uoc.ei.tads.Iterador;
import uoc.ei.tads.ListaEncadenada;

import java.util.Comparator;

public class Game implements Comparable<Game> {
    private String description;
    private String idGame;
    private ListaEncadenada<Level> levels;
    private int nPlays;

    public static Comparator<String> CMP = new Comparator<String>() {
        @Override
        public int compare(String idGame1, String idGame2) {
            return idGame1.compareTo(idGame2);
        }
    };

    public static Comparator<Game> CMP_PLAYER = new Comparator<Game>() {
        @Override
        public int compare(Game game1, Game game2) {
            return game1.numPlays()-game2.numPlays();
        }
    };



    public Game(String idGame, String description) {
        this.idGame = idGame;
        this.description = description;
        this.nPlays = 0;
        this.levels = new ListaEncadenada<Level>();
    }

    public Level getLevel(String idLevel) {
        Iterador<Level> it = this.levels.elementos();
        boolean found = false;

        Level aux = null;

        while (it.haySiguiente() && !found) {
            aux = it.siguiente();
            found = aux.getIdLevel().equals(idLevel);
        }

        return (found?aux:null);
    }

    public void addLevel(Level l) {
        this.levels.insertarAlFinal(l);
    }

    public void updateTOPGames() {
        this.nPlays++;
    }

    public int numPlays() {
        return this.nPlays;
    }

    public int numLevels() {
        return this.levels.numElems();
    }

    public String getIdGame() {
        return idGame;
    }

    @Override
    public int compareTo(Game o) {
        return this.idGame.compareTo(o.idGame);
    }


}
