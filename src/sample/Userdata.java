package sample;

public class Userdata {

    private String email;
    private String name;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public Userdata(String email,String name, String username, String password){
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return name;
    }


}
