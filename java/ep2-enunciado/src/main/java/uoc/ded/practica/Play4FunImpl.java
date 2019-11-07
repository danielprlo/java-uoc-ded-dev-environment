package uoc.ded.practica;

import uoc.ei.tads.DiccionarioVectorImpl;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.ListaEncadenada;
import uoc.ei.tads.Posicion;
import uoc.ei.tads.Recorrido;

public class Play4FunImpl implements Play4Fun {

	ListaEncadenada<User> users;
	DiccionarioVectorImpl gameVector;
	
	public Play4FunImpl() {
		this.users = new ListaEncadenada<User>();
		this.gameVector = new DiccionarioVectorImpl(100);
	}
	
	public void addUser(String idUser, String name, String surname) {
			
		if (this.getUser(idUser) != null) {
			this.updateExistingser(idUser, name, surname);
		} else {
			this.users.insertarAlFinal(new User(idUser, name, surname));
		}
	}

	public void playGame(String idUser, String idGame) {
		// TODO Auto-generated method stub

	}

	public int numUsers() {
		return this.users.numElems();
	}

	public int numGames() {
		return this.gameVector.numElems();
	}

	public int numLevels(String idGame) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numScreens(String idGame, String idLevel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addGame(String idGame, String description) throws GameAlreadyExistsException {
		Game newGame = new Game(idGame, description);

		if (this.gameVector.esta(idGame)) {
			System.out.println("hay uno");
			throw new GameAlreadyExistsException("Game "+idGame+" already exists");
		}
		
		this.gameVector.insertar(idGame, newGame);
	}

	public void addLevel(String idLevel, String idGame, String name, int hardness, int nLevelScreens)
			throws LevelAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	public void addScreen(String idGame, String idLevel, int idScreen, int points) throws LevelFullException {
		// TODO Auto-generated method stub
		
	}

	public void nextScreen(String idUser, String idGame, String idLevel, int levelScreenId, int points)
			throws NoEnoughPointsException {
		// TODO Auto-generated method stub
		
	}

	public Iterador<Move> topUsersForScreen(String idGame, String idLevel, int levelScreenID)
			throws GameNotFoundException, LevelNotFoundException, ScreenNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterador<Game> topGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String idUser) {
		
		if (!this.users.estaVacio()) {
			Iterador<User> iterator = this.users.elementos();
			
			while (iterator.haySiguiente()) {
				User user = iterator.siguiente(); 
				if (user.getIdUser() == idUser) {
					return user;
				}
			}
		}
		
		return null; 
	}
	
	private void updateExistingser(String idUser, String name, String surname) {
		Recorrido<User> rec = this.users.posiciones();
		Posicion<User> pos = null;
		boolean found = false;
		
		while (rec.haySiguiente() && !found) {
			pos = rec.siguiente();
			if (pos.getElem().getIdUser() == idUser) {
				pos.getElem().setName(name);
				pos.getElem().setSurname(surname);
				
				this.users.reemplazar(pos, pos.getElem());
				found = true;
			}
		}
	}

}
