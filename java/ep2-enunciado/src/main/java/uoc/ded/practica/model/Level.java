package uoc.ded.practica.model;

public class Level {

    private String idLevel;
    private String name;
    private int hardness;
    private Screen[] screens;
    private int numScreens;


    public Level(String idLevel, String name, int hardness, int nLevelScreens) {
        this.idLevel = idLevel;
        this.name = name;
        this.hardness = hardness;
        this.screens = new Screen[nLevelScreens];
        this.numScreens = 0;
    }

    public String getIdLevel() {
        return idLevel;
    }

    public void addScreen(int idScreen, int points) {
        Screen s = new Screen(idScreen, points);
        this.screens[idScreen] = s;
        this.numScreens++;
    }

    public Screen getScreen(int idScreen) {
        return this.screens[idScreen];
    }

    public int numScreens() {
        return this.numScreens;
    }

    public boolean isFull() {
        return this.screens.length == this.numScreens;
    }
}
