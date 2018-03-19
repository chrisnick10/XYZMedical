package xyzmedical.model;

/**
 *
 * @author Will
 */
public abstract class Person extends Object {
    protected int ID;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    
    public Person(int ID, String firstName, String lastName, String username, 
                String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public boolean passwordMatches(String password) {
        return this.password.equals(this.password);
    }
    
    @Override
    public String toString() {
        return "[" + this.ID + "] " + this.lastName + ", " + this.firstName;
    }
}
 