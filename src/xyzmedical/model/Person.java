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
    
    public Person(int ID, String firstName, String lastName, String username, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "[" + this.ID + "] " + this.lastName + ", " + this.firstName;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }
}
 