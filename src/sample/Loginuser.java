package sample;

public class Loginuser {

    private String username;
    private String name;
    private String movie;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setMovie(String username,String name,String movie) {
        this.username = username;
        this.name = name;
        this.movie = movie;
    }
}
