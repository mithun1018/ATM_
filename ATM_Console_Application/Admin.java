package ATM_Console_Application;
import java.util.ArrayList;
public class Admin {
    private static ArrayList<String> atmTransactionHistory = new ArrayList<>();
    private  String adminName ;
    private  String pin;
    public Admin(String AdminName, String newpin)
    {
       this.adminName=AdminName;
       this.pin=newpin;
    }


    public void setAdminName(String AdminName){
        adminName=AdminName;
    }
    public void setAdminpin(String Adminpin){
        pin=Adminpin;
    }
    public  String getAdminName()
    {
        return adminName;
    }

    public  String getpin()
    {
        return pin;
    }

    public static void addATMTransactionHistory(String transaction)
    {
        Admin.atmTransactionHistory.add(transaction);
    }
    public static ArrayList<String>  AtmTransactionHistory(){
        return atmTransactionHistory;
    }

}