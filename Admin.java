package firstapp;

import java.util.Scanner;

public class Admin extends user {
    
    Scanner s = new Scanner(System.in);

    public Admin() {};
    public Admin(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Returne List of staff with their global collection
    public void ShowAllStaff() {
        System.out.println("List of the Staff: ");
        for (Staff staff : MainClass.staffs) {
            System.out.println("------------------------------------------------");
            System.out.println("ID: " + staff.getId() + " | Name: " + staff.getName() + " | email: " + staff.getEmail()
                    + " | password: " + staff.getPassword());
            staff.ShowMyCollections_Values();
        }
        System.out.println("------------------------------------------------");
    }

    // Returne list collections not Shedule
    public void ShowAllCollection_not_Shedule() {
        System.out.println("List collections not Shedule: ");
        for (Collection collection : MainClass.Collections) {
            if (!collection.get_is_Schedule()) {
                System.out.println("------------------------------------------------");
                System.out.println("ID: " + collection.getCollectionId() +" Staff ID: "+collection.getUserId()+ " Date: "
                        + MainClass.formatter.format(collection.getDate()) + " location: " + collection.getLocation());
                System.out.println("wood : " + collection.getTypeOfWaste().get("wood") + " | glass : "
                        + collection.getTypeOfWaste().get("glass") + " | metal : "
                        + collection.getTypeOfWaste().get("metal") + " | paper : "
                        + collection.getTypeOfWaste().get("paper") + " | plastic : "
                        + collection.getTypeOfWaste().get("plastic"));
            }
        }
        System.out.println("------------------------------------------------");
    }

    // Returne List collections Sheduled
    public void ShowAllCollection_Shedule() {
        System.out.println("List collections Sheduled: ");
        for (Collection collection : MainClass.Collections) {
            if (collection.get_is_Schedule()) {
                System.out.println("------------------------------------------------");
                System.out.println("ID: " + collection.getCollectionId()+" Staff ID: "+collection.getUserId() + " Date: "
                        + MainClass.formatter.format(collection.getDate()) + " location: " + collection.getLocation());
                System.out.println("wood : " + collection.getTypeOfWaste().get("wood") + " | glass : "
                        + collection.getTypeOfWaste().get("glass") + " | metal : "
                        + collection.getTypeOfWaste().get("metal") + " | paper : "
                        + collection.getTypeOfWaste().get("paper") + " | plastic : "
                        + collection.getTypeOfWaste().get("plastic"));
            }
        }
        System.out.println("------------------------------------------------");
    }

    // update Staff
    public boolean updatestaff(){
        int staff_ID;
        String name,password;
        System.out.println("Entre Staff ID you want to update: ");
        try {
            staff_ID=s.nextInt();
        } catch (Exception e) {
            System.out.println("staff ID must be Number !!!");
            s.nextLine();
            return false;
        }
        for (Staff staff : MainClass.staffs) {
            if(staff.getId()==staff_ID){
                System.out.println("Entre Staff new name: ");
                name=MainClass.scanner.nextLine();
                System.out.println("Entre Staff new password: ");
                password=MainClass.scanner.nextLine();
                staff.update(name, password);
                return true;
            }
        }
        System.out.println("staff ID not found !!!");
        return false;

    }
    
    // delete Staff
    public boolean DropStaff(){
        int staff_ID;
        System.out.println("Entre Staff ID you want to Delete: ");
        try {
            staff_ID=s.nextInt();
        } catch (Exception e) {
            System.out.println("staff ID must be Number !!!");
            s.nextLine();
            return false;
        }
        for (Staff staff : MainClass.staffs) {
            if(staff.getId()==staff_ID){
                MainClass.staffs.remove(staff);
                return true;
            }
        }
        System.out.println("staff ID not found !!!");
        return false;
    }
}
