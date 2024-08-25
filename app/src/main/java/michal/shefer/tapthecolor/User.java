package michal.shefer.tapthecolor;

import java.util.ArrayList;

public class User {
    String userName;
    String userPassword;
    String userEmail;
    String userScore;
    ArrayList users = new ArrayList<User>();

    public ArrayList getUsers() {
        return users;
    }

    public void setUsers(ArrayList users) {
        this.users = users;
    }
    public User(String userName, String userPassword, String userEmail) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userScore = userScore;
    }
    public User(String userName, String userPassword, String userEmail, String userScore) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }
}
