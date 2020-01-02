package uoc.ded.practica.model;

    public class Move implements Comparable<Move> {
        User user;
        int points;

        public Move(User user, int points) {
            this.user = user;
            this.points = points;
        }

        public int compareTo(Move m) {
            return this.user.getId().compareTo(m.user.getId());
        }


        public User getUser() {
            return user;
        }

        public int getPoints() {
            return points;
        }
    }
