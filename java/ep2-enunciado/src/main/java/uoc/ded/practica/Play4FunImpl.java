package uoc.ded.practica;

import java.util.Date;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionarioOrderedVector;
import uoc.ded.practica.util.ListaEncadenadaOrdenada;
import uoc.ei.tads.*;

public class Play4FunImpl implements Play4Fun {

    private ListaEncadenada<User> users;
    private DiccionarioOrderedVector<String, Game> games;
    private ListaEncadenadaOrdenada<Game> topGames;

    public Play4FunImpl() {
        this.users = new ListaEncadenada<User>();
        this.games = new DiccionarioOrderedVector(Play4Fun.J, Game.CMP);

        this.topGames = new ListaEncadenadaOrdenada<Game>(Game.CMP_PLAYER);
    }


    public void addUser(String idUser, String name, String surname) {
        User u = this.getUser(idUser);
        if (u != null) {
            u.setName(name);
            u.setSurname(surname);
        } else {
            u = new User(idUser, name, surname);
            this.users.insertarAlFinal(u);
        }

    }

    @Override
    public void addGame(String idGame, String description) throws GameAlreadyExistsException {

        Game g = this.games.consultar(idGame);
        if (g!=null) throw new GameAlreadyExistsException();

        this.games.insertar(idGame, new Game(idGame, description));
        
    }

    @Override
    public void addLevel(String idLevel, String idGame, String name, int hardness, int nLevelScreens)
            throws LevelAlreadyExistsException {

        Game g = this.games.consultar(idGame);
        Level l = g.getLevel(idLevel);
        if (l!=null) throw new LevelAlreadyExistsException();
        l = new Level(idLevel, name, hardness, nLevelScreens);
        g.addLevel(l);


    }

    @Override
    public void addScreen(String idGame, String idLevel, int idScreen, int points)
            throws LevelFullException {

        Game g = this.games.consultar(idGame);
        Level l = g.getLevel(idLevel);
        if (l.isFull()) throw new LevelFullException();

            Screen screen = l.getScreen(idScreen);
        if (screen==null) {
            l.addScreen(idScreen, points);
        }
        else screen.setPoints(points);

    }

    @Override
    public void playGame(String idUser, String idGame) {
        User user = this.getUser(idUser);

        Game game = this.games.consultar(idGame);
        game.updateTOPGames();
        this.topGames.update(game);
    }

    @Override
    public void nextScreen(String idUser, String idGame, String idLevel, int levelScreenId, int points)
            throws NoEnoughPointsException {


        User user = this.getUser(idUser);
        Game game = this.games.consultar(idGame);
        Level level = game.getLevel(idLevel);
        Screen screen = level.getScreen(levelScreenId);

        if (points>=screen.getPoints()) {
            screen.updateTOPPlayers(user, points);
        }
        else throw new NoEnoughPointsException();



    }

    @Override
    public Iterador<Move> topUsersForScreen(String idGame, String idLevel, int levelScreenID)
            throws GameNotFoundException, LevelNotFoundException, ScreenNotFoundException {

        Game game = this.games.consultar(idGame);
        if (game == null) throw new GameNotFoundException();

        Level level = game.getLevel(idLevel);
        if (level == null) throw new LevelNotFoundException();

        Screen screen = level.getScreen(levelScreenID);
        if (screen == null) throw new ScreenNotFoundException();

        Iterador<Move> topPlayers = screen.topPlayers();

        return topPlayers;
    }

    @Override
    public Iterador<Game> topGames() {

        Iterador<Game> it = this.topGames.elementos();

        return it;
    }

    public int numUsers() {
        return this.users.numElems();
    }

    public int numGames() { return this.games.numElems(); }

    public int numLevels(String idGame) {
        Game g = this.games.consultar(idGame);

        return (g==null?0: g.numLevels());
    }


    public int numScreens(String idGame, String idLevel) {
        int ret = 0;
        Game g = this.games.consultar(idGame);
        if (g!=null) {
            Level l = g.getLevel(idLevel);
            if (l!=null) ret = l.numScreens();
        }

        return ret;
    }



    public User getUser(String idUser) {
        Iterador<User> it = this.users.elementos();
        boolean found = false;
        User theUser = null;

        while (!found && it.haySiguiente()) {
            theUser = it.siguiente();
            found = theUser.getId().equals(idUser);
        }

        return (found? theUser: null);
    }


	@Override
	public void addMatch(String matchID, String gameID) throws MatchAlreadyExistsException, GameNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void joinMatch(String matchID, String userID) throws MatchNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void kill(String matchID, String killerID, String killedID, int points) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PlayerScore topUserForGame(String gameID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void sendPublicMessage(String matchID, String userID, String message, Date date)
			throws MatchNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendPrivateMessage(String matchID, String senderID, String receiverID, String message, Date date)
			throws MatchNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Iterador<Message> publicMessages(String matchID) throws MatchNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterador<Message> privateMessages(String matchID, String userID)
			throws MatchNotFoundException, UserNotFoundException, UserNotInMatchException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int numMatches() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int numUsersByMatch(String matchID) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public PlayerScore getPlayerFromMatch(String matchId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
