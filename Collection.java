package firstapp;
import java.util.*;


public class Collection {
    static int auto_increment=1;
    private int collectionId;
    private int userId;
    private Date date;
    private HashMap<String, Integer> typeOfWaste;
    private String location;
    private boolean is_Schedule=false;

    //getters
    public int getCollectionId() {
        return collectionId;
    }
    public int getUserId() {
        return userId;
    }
    public Date getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public boolean get_is_Schedule() {
        return is_Schedule;
    }
    public HashMap<String, Integer> getTypeOfWaste() {
            return typeOfWaste;
        }

    //Constructor
    public Collection(int userId, String location, HashMap<String, Integer> wastes) {
        this.collectionId = auto_increment;
        this.userId = userId;
        this.date = new Date();
        this.location = location;
        this.typeOfWaste = new HashMap<>(wastes); 
        auto_increment++;
    }

    public void update(String location, HashMap<String, Integer> wastes) {
        this.location = location;
        this.typeOfWaste = new HashMap<>(wastes); 
    }
    
    public void collection_shedule(String shedule_location){
        Schedule shd=new Schedule(shedule_location, this);
        this.is_Schedule=true;
        MainClass.schedules.add(shd);

    }

}
