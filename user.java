package firstapp;

abstract class user {
    static int auto_increment=1;
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String role;

    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    
    public user(){}
    public user(String nom,String email,String password,String role){
        this.id=auto_increment;
        this.name=nom;
        this.email=email;
        this.password=password;
        this.role=role;
        auto_increment++;
    }
    
    public abstract void update( String name,String password);

    public static boolean not_exist_check(user user){
        for (Admin ad : MainClass.admins) {
            if(ad.email==user.email){return false;}
        }
        for (Staff st : MainClass.staffs) {
            if(st.email==user.email){return false;}
        }
        return true;
    }
}
