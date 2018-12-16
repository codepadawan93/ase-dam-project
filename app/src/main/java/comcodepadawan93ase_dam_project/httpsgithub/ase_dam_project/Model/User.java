package comcodepadawan93ase_dam_project.httpsgithub.ase_dam_project.Model;

public class User {
    private  int user_id;
    private String userName;
    private String password;
    private String userNameSign;
    private String userEmail;
    private String role;

    public User(){
        this.userName = "";
        this.password = "";
        this.userNameSign = "";
        this.userEmail = "";
        this.role = "";
    }

    public User(int id){
        this.user_id = id;
    }

    public User(int user_id, String userName, String password, String firstName, String lastName, String role) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.userNameSign = firstName;
        this.userEmail = lastName;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        userName.hashCode();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return userNameSign;
    }

    public void setUserNameSign(String userNameSign) {
        this.userNameSign = userNameSign;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
