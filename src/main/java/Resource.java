import java.util.Date;

public class Resource {
    private int id;
    private String name;
    private String count;
    private String  date;
    private boolean isStatus;

    public Resource(int id, String name,  String count, String date, boolean isStatus){
        this.id = id;
        this.name = name;
        this.count = count;
        this.date = date;
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
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String  getDate() {
        return date;
    }
    public void setDate(String  date) {
        this.date = date;
    }
    public boolean isStatus() {
        return isStatus;
    }
    public void setStatus(boolean isStatus) {
        this.isStatus = isStatus;
    }
}
