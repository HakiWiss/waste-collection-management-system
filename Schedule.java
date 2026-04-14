package firstapp;
import java.util.*;

public class Schedule {
    static int auto_increment=1;
    private int Sch_ID;
    private Date Sch_date;
    private String Sch_location;
    private Collection Sch_collection;

    public Schedule(){}
    
    public Schedule(String location,Collection collection){
        this.Sch_ID=auto_increment;
        this.Sch_date=new Date();
        this.Sch_location=location;
        this.Sch_collection=collection;
        auto_increment++;
    }
    
    

}
