package uoc.ded.practica.model;

import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.Iterador;

import java.util.Comparator;

public class Screen {
    private int idScreen;
    private int points;
    private OrderedVector<Move> topPlayers;

    private Comparator<Move> CMP = new Comparator<Move>() {
        @Override
        public int compare(Move o1, Move o2) {
            return o1.points-o2.points;
        }
    };

    public Screen(int idScreen, int points) {
        this.idScreen = idScreen;
        this.points = points;
        this.topPlayers = new OrderedVector<Move>(10, CMP);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public void updateTOPPlayers(User user, int points) {

        Move m = new Move(user, points);
        this.topPlayers.update(m);
    }

    public Iterador<Move> topPlayers() {
        return this.topPlayers.elementos();
    }


}
