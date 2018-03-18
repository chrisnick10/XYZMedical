package xyzmedical.model;

public class User {
    protected int ID;
    protected int accessLevel;
    protected String username;
    protected String password;
    
    public User(int ID, int accessLevel, String username, String password) {
            this.ID = ID;
            this.accessLevel = accessLevel;
            this.username = username;
            this.password = password;
    }
    
    public int getID() {
        return ID;
    }
    
    public int getAccessLevel() {
        return accessLevel;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}