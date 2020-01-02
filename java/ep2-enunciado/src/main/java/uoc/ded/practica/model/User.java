package uoc.ded.practica.model;

public class User implements Comparable<User>{
    private String id;
    private String name;
    private String surname;

    public User(String idUser, String name, String surname) {
        this.setId(idUser);
        this.setName(name);
        this.setSurname(surname);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public int compareTo(User o) {
        return this.getId().compareTo(o.getId());
    }
}
