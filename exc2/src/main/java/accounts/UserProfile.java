package accounts;

/**
 * Created by Илья on 08.03.2016.
 */
public class UserProfile {
    private final String login;
    private final String pass;
    //private final String email;

    public UserProfile(String login, String pass){
        this.login = login;
        this.pass = pass;
        //this.email = email;
    }

    public UserProfile(String login){
        this.login = login;
        this.pass = login;
        //this.email = login;
    }

    public String getLogin(){ return login;}

    public String getPass(){ return pass; }

    public String toString(){
        return getLogin() + " " + getPass();
    }
    //public String getEmail(){ return email; }
}
