package firstapp;
import java.util.*;
import java.text.SimpleDateFormat;

public class Staff extends user{
    
    //List Collections handle by this staff
    private ArrayList<Collection> staff_Collections = new ArrayList<Collection>();

    private HashMap<String, Integer> staffWaste=new HashMap<String, Integer>(); //dictionary key value
    Scanner scanner = new Scanner(System.in);

    public Staff(){};

    public Staff( String name, String email,String password) {
        super( name, email, password,"staff");
        staffWaste.put("wood", null);
        staffWaste.put("glass", null);
        staffWaste.put("metal", null);
        staffWaste.put("paper", null);
        staffWaste.put("plastic", null);
    }
    
    public void update(String name,String password){
        this.name=name;
        this.password=password;
    }

    // add collection by this staff
    public void addcollection(String location,HashMap<String, Integer> fun_wastes){
        HashMap<String, Integer> copyOfWastes = new HashMap<>(fun_wastes);
        Collection col=new Collection( this.id, location, copyOfWastes);
        MainClass.Collections.add(col);
        staff_Collections.add(col); 
    }

    // Show staff global collection value(sum values)
    public void ShowMyCollections_Values(){
        int wood=0; int glass=0; int metal=0; int paper=0; int plastic=0;
        for (Collection collection : staff_Collections) {
            wood+=collection.getTypeOfWaste().get("wood");
            glass+=collection.getTypeOfWaste().get("glass");
            metal+=collection.getTypeOfWaste().get("metal");
            paper+=collection.getTypeOfWaste().get("paper");
            plastic+=collection.getTypeOfWaste().get("plastic");
        }
        System.out.println("global "+this.name+" collections value:");
        System.out.println("wood : "+wood+" | glass : "+glass+" | metal : "+metal+" | paper : "+paper+" | plastic : "+plastic);
    }

    //update Collection by this staff
    public boolean updateCollection() {
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        //Show staff collection not Scheduled
        System.out.println(" " + this.name + " collections not Scheduled:");
        for (Collection collection : staff_Collections) {
            if (!collection.get_is_Schedule()) {
                id_list.add(collection.getCollectionId());
                System.out.println("------------------------------------------------");
                System.out.println("ID: " + collection.getCollectionId() + " Date: " + MainClass.formatter.format(collection.getDate()) + " location: " + collection.getLocation());
                System.out.println("wood : " + collection.getTypeOfWaste().get("wood") + " | glass : " + collection.getTypeOfWaste().get("glass") + " | metal : " + collection.getTypeOfWaste().get("metal") + " | paper : " + collection.getTypeOfWaste().get("paper") + " | plastic : " + collection.getTypeOfWaste().get("plastic"));
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("what's the id of collection you want to modify: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
             
        } catch (Exception e) {
            System.out.println("collection ID must be Number !!!");
            return false;
        }
        //check if collection id exist
        if (id_list.contains(id)) {
            System.out.println("new location : ");
            String location = scanner.nextLine();
            int wood, glass, metal, paper, plastic;
            try {
                System.out.println("wood size (g): ");
                wood = scanner.nextInt();
                System.out.println("glass size (g): ");
                glass = scanner.nextInt();
                System.out.println("metal size (g): ");
                metal = scanner.nextInt();
                System.out.println("paper size (g): ");
                paper = scanner.nextInt();
                System.out.println("plastic size (g): ");
                plastic = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("waste size must be Number !!!");
                return false;
            }
            //update Collection 
            for (Collection collection : staff_Collections) {
                if (collection.getCollectionId() == id) {
                    staffWaste.put("wood", wood);
                    staffWaste.put("glass", glass);
                    staffWaste.put("metal", metal);
                    staffWaste.put("paper", paper);
                    staffWaste.put("plastic", plastic);
                    collection.update(location, staffWaste);
                    return true;
                }
            }
        } else {
            System.out.println("Collection ID not found !!!");
            return false;
        }
        System.out.println("Collection ID not found !!!");
        return false;
    }

    // shedule collection 
    public boolean SheduleCollection(){
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        //Show staff collection not Scheduled
        System.out.println(" "+this.name+" collections not Sheduled:");
        for (Collection collection : staff_Collections) {
            if(collection.get_is_Schedule()==false){
                id_list.add(collection.getCollectionId());
                System.out.println("------------------------------------------------");
                System.out.println("ID: "+collection.getCollectionId()+" Date: "+MainClass.formatter.format(collection.getDate())+" location: "+collection.getLocation());
                System.out.println("wood : "+collection.getTypeOfWaste().get("wood")+" | glass : "+collection.getTypeOfWaste().get("glass")+" | metal : "+collection.getTypeOfWaste().get("metal")+" | paper : "+collection.getTypeOfWaste().get("paper")+" | plastic : "+collection.getTypeOfWaste().get("plastic"));
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("what's the id of collection you want to shedule: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("collection ID must be Number !!!");
            return false;
        }
        //check if collection id exist
        if(id_list.contains(id)){
            System.out.println("Shedule location : ");
            String location=scanner.nextLine();
            //Shedule collection
            for (Collection collection : staff_Collections) {
                if(collection.getCollectionId()==id){
                    collection.collection_shedule(location);
                    return true;
                }
            } 
        }else{System.out.println("Collection ID not found !!!"); return false;}
        System.out.println("Collection ID not found !!!");
        return false;
    }
}