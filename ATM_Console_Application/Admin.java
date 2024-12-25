package ATM_Console_Application;
import java.util.ArrayList;
public class Admin {
    private static ArrayList<String> atmTransactionHistory = new ArrayList<>();
    private static String adminName = "123";
    private static String pin = "1234";

    // for admins
    public static String getAdminName()
    {
        return adminName;
    }

    public static String getpin()
    {
        return pin;
    }

    public static void addATMTransactionHistory(String transaction)
    {
        Admin.atmTransactionHistory.add(transaction);
    }

}