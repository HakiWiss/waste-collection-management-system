package firstapp;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {

    public static ArrayList<Staff> staffs = new ArrayList<Staff>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Collection> Collections = new ArrayList<Collection>();
    public static ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static HashMap<String, Integer> Main_wastes = new HashMap<String, Integer>();
    public static Scanner scanner = new Scanner(System.in);
    static Admin currentAdmin;
    static Staff currenStaff;
    static boolean islogin = false;
    static boolean notquit = true;

    public static void main(String[] args) {
        // create admin and staff ali
        Admin ad = new Admin("admin", "admin@gmail.com", "admin");
        Staff stf = new Staff("ali", "ali@gmail.com", "ali");
        // create an collection initial to staff ali
        Main_wastes.put("wood", 4);
        Main_wastes.put("glass", 5);
        Main_wastes.put("metal", 6);
        Main_wastes.put("paper", 7);
        Main_wastes.put("plastic", 8);
        stf.addcollection("rabat", Main_wastes);

        admins.add(ad);
        staffs.add(stf);

        // handle interface type: (home, admin or staff)
        while (notquit) {
            if (currenStaff == null && currentAdmin == null) {
                no_login_print(); // si not login yet 
            } else if (currenStaff != null && currentAdmin == null) {
                staff_home();
            } else if (currenStaff == null && currentAdmin != null) {
                admin_home();
            }
        }
    }

    // Home interface
    public static void no_login_print() {
        String option;
        boolean end = false;
        while (!end) {
            System.out.print("\033\143");
            System.out.println("welcome to our App GreenCollect");
            System.out.println("First we need your identification: ");
            System.out.println("To login (Write --> 1) .");
            System.out.println("To sign up (Write --> 2) .");
            System.out.println("To Quit (Write --> 0) .");
            System.out.println("What is your option:  ");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    end = login();
                    break;
                case "2":
                    end = signup();
                    break;
                case "0":
                    notquit = false;
                    end = true;
                    break;
                default:
                    System.out.println("-------------------");
                    System.out.println("!! Please entre a number between 0 and 2 !!!");
                    System.out.println("-------------------");
                    break;
            }
        }
    }

    // staff interface
    public static void staff_home() {
        String option;
        while ((currenStaff != null)) {
            System.out.print("\033\143");
            System.out.println("welcome " + currenStaff.name);
            System.out.println("what you want to check: ");
            System.out.println("Add collection (Write --> 1) .");
            System.out.println("show global value collections (Write --> 2) .");
            System.out.println("update your collections (Write --> 3) .");
            System.out.println("Shedule a collection (Write --> 4) .");
            System.out.println("To log out (Write --> 0) .");
            System.out.println("What is your option:  ");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    staff_addCollection();
                    break;
                case "2":
                    System.out.print("\033\143");
                    currenStaff.ShowMyCollections_Values();
                    System.out.println("press entre to back:  ");
                    option = scanner.nextLine();
                    break;
                case "3":
                    System.out.print("\033\143");
                    if (currenStaff.updateCollection()) {
                        System.out.println("Collection updated");
                    } else {
                        System.out.println("error , collection not updated");
                    }
                    System.out.println("press entre to back:  ");
                    option = scanner.nextLine();
                    break;
                case "4":
                    System.out.print("\033\143");
                    if (currenStaff.SheduleCollection()) {
                        System.out.println("Collection Sheduled");
                    } else {
                        System.out.println("error , collection not Sheduled");
                    }
                    System.out.println("press entre to back:  ");
                    option = scanner.nextLine();
                    break;
                case "0":
                    currenStaff = null;
                    break;
                default:
                    System.out.println("-------------------");
                    System.out.println("!! Please entre a number between 0 and 3 !!!");
                    System.out.println("-------------------");
                    break;
            }
        }

    }

    // Admin inteface
    public static void admin_home() {
        String option;
        while ((currentAdmin != null)) {
            System.out.print("\033\143");
            System.out.println("welcome " + currentAdmin.name);
            System.out.println("what you want to check: ");
            System.out.println("show all Staffs (Write --> 1) .");
            System.out.println("Add staff (Write --> 2) .");
            System.out.println("Update staff (Write --> 3) .");
            System.out.println("Delete Staff (Write --> 4) .");
            System.out.println("show all Collections not Shedule (Write --> 5) .");
            System.out.println("show all Collections Sheduled (Write --> 6) .");
            System.out.println("To log out (Write --> 0) .");
            System.out.println("What is your option:  ");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.print("\033\143");
                    currentAdmin.ShowAllStaff();
                    System.out.println("press entre to back ");
                    option = scanner.nextLine();
                    break;
                case "2":
                    System.out.print("\033\143");
                    boolean addstaff = signup();
                    break;
                case "3":
                    System.out.print("\033\143");
                    if (currentAdmin.updatestaff()) {
                        System.out.println("Staff updated");
                    } else {
                        System.out.println("error , Staff not updated");
                    }
                    System.out.println("press entre to back ");
                    option = scanner.nextLine();
                    break;
                case "4":
                    System.out.print("\033\143");
                    if (currentAdmin.DropStaff()) {
                        System.out.println("Staff Deleted");
                    } else {
                        System.out.println("error , Staff not Deleted");
                    }
                    System.out.println("press entre to back ");
                    option = scanner.nextLine();
                    break;
                case "5":
                    System.out.print("\033\143");
                    currentAdmin.ShowAllCollection_not_Shedule();
                    ;
                    System.out.println("press entre to back ");
                    option = scanner.nextLine();
                    break;
                case "6":
                    System.out.print("\033\143");
                    currentAdmin.ShowAllCollection_Shedule();
                    System.out.println("press entre to back ");
                    option = scanner.nextLine();
                    break;
                case "0":
                    currentAdmin = null;
                    break;
                default:
                    System.out.println("-------------------");
                    System.out.println("!! Please entre a number between 0 and 5 !!!");
                    System.out.println("-------------------");
                    break;
            }
        }
    }

    // login function  --utilise dans no login interface 
    public static boolean login() {
        boolean account_found = false;
        System.out.print("\033\143");
        System.out.println("please choose type of login !!");
        System.out.println("login as admin (Write --> 1) .");
        System.out.println("login as staff (Write --> 2) .");
        System.out.println("What is your option:  ");
        String typeOption = scanner.nextLine();
        if (typeOption.equals("1")) {
            System.out.println("entre you email :");
            String adm_email = scanner.nextLine();
            System.out.println("entre you password :");
            String adm_psw = scanner.nextLine();
            for (Admin admin : admins) {
                if (admin.email.equals(adm_email) && admin.password.equals(adm_psw)) {
                    account_found = true;
                    currentAdmin = admin;
                    currenStaff = null;
                    break;
                }
            }
            if (account_found) {
                System.out.println("you login as admin successfully !!");
                System.out.println("press entre to continue:  ");
                scanner.nextLine();
                return true;
            } else {
                System.out.println("admin account not found  !!");
                System.out.println("press entre to back:  ");
                scanner.nextLine();
                return false;
            }
        } else if (typeOption.equals("2")) {
            System.out.println("entre you email :");
            String stf_email = scanner.nextLine();
            System.out.println("entre you password :");
            String stf_psw = scanner.nextLine();
            for (Staff staff : staffs) {
                if (staff.email.equals(stf_email) && staff.password.equals(stf_psw)) {
                    account_found = true;
                    currenStaff = staff;
                    currentAdmin = null;
                    break;
                }
            }
            if (account_found) {
                System.out.println("you login as staff  successfully !!");
                System.out.println("press entre to continue:  ");
                scanner.nextLine();
                return true;
            } else {
                System.out.println("staff account not found  !!");
                System.out.println("press entre to back:  ");
                scanner.nextLine();
                return false;
            }
        } else {
            return false;
        }
    }

    // sign up (just admin can add new staff) --utilise dans no login interface et admin options
    public static boolean signup() {
        System.out.print("\033\143");
        if (currentAdmin == null) {
            boolean admin_found = false;
            System.out.println("to sign up a new staff you need to login as admin !!");
            System.out.println("To contun (Write --> 1) .");
            System.out.println("To Quit (Write --> 0) .");
            System.out.println("What is your option:  ");
            String option = scanner.nextLine();
            if (option.equals("0")) {
                return false;
            }
            System.out.println("entre you email :");
            String adm_email = scanner.nextLine();
            System.out.println("entre you password :");
            String adm_psw = scanner.nextLine();
            for (Admin admin : admins) {
                if (admin.email.equals(adm_email) && admin.password.equals(adm_psw)) {
                    admin_found = true;
                    break;
                }
            }
            if (admin_found) {
                System.out.println("you login as admin successfully !!");
                addstaff();
                System.out.println("press entre to continue:  ");
                option = scanner.nextLine();
                return true;
            } else {
                System.out.println("admin account not found  !!");
                System.out.println("press entre to back:  ");
                option = scanner.nextLine();
                return false;
            }
        } else {
            addstaff();
            System.out.println("press entre to continue:  ");
            scanner.nextLine();
            return true;
        }

    }

    // admin functions --utilise dans methods sign_up et admin add staff
    public static void addstaff() {
        System.out.println("entre you staff name :");
        String name = scanner.nextLine();
        System.out.println("entre you staff email :");
        String email = scanner.nextLine();
        System.out.println("entre you staff password :");
        String psw = scanner.nextLine();
        Staff new_Staff = new Staff(name, email, psw);
        if (user.not_exist_check(new_Staff)) {
            staffs.add(new_Staff);
            System.out.println("Staff add successfully  !!");
        } else {
            System.out.println("Staff not add because email already exist !!");
        }
    }

    // staff functions --utilise dans staff options 
    public static void staff_addCollection() {
        System.out.print("\033\143");
        System.out.println("please entre new collection information !!");
        System.out.println("collection location : ");
        String location = scanner.nextLine();
        try {
            System.out.println("wood size (g): ");
            int wood = scanner.nextInt();
            System.out.println("glass size (g): ");
            int glass = scanner.nextInt();
            System.out.println("metal size (g): ");
            int metal = scanner.nextInt();
            System.out.println("paper size (g): ");
            int paper = scanner.nextInt();
            System.out.println("plastic size (g): ");
            int plastic = scanner.nextInt();
            Main_wastes.put("wood", wood);
            Main_wastes.put("glass", glass);
            Main_wastes.put("metal", metal);
            Main_wastes.put("paper", paper);
            Main_wastes.put("plastic", plastic);
            currenStaff.addcollection(location, Main_wastes);
            System.out.println("new collection add successfully !!");
        } catch (Exception e) {
            System.out.println("error in input of information!!");
        }
        System.out.println("press entre to  continue!!");
        scanner.nextLine();

    }

}