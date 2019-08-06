import java.util.ArrayList;
import java.util.Date;


public class User {

    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String  birddate;
    private String contract;
    private String role;
    private ArrayList<Resource> resource;
    private boolean isStatus;

    public User(int id, String name,  String lastname,  String email, String password, String birddate, String contract, String role, ArrayList<Resource> resource, boolean isStatus){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birddate = birddate;
        this.contract = contract;
        this.role = role;
        this.resource = resource;
        this.isStatus = isStatus;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String  getBirddate() {
        return birddate;
    }
    public void setBirddate(String  birddate) {
        this.birddate = birddate;
    }
    public String getContract() {
        return contract;
    }
    public void setContract(String contract) {
        this.contract = contract;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public ArrayList<Resource> getResource(){
        return resource;
    }
    public void setResource(ArrayList<Resource> resource){
        this.resource = resource;
    }
    public boolean isStatus() {
        return isStatus;
    }
    public void setStatus(boolean isStatus) {
        this.isStatus = isStatus;
    }
}
