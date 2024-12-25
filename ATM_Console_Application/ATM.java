package ATM_Console_Application;
import java.util.ArrayList;
import java.util.Scanner;


public class ATM
{
    private static ArrayList<User> userArray = new ArrayList<>();
    private static double balance;
    public static ArrayList<User> getAvailableUsers()
    {
        return userArray;
    }
    public static double getBalance()
    {
        return ATM.balance;
    }
    public static void setBalance(double balance)
    {
        ATM.balance = balance;

    }
    public static void start() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1.Admin\n2.User\n3.Exit\nEnter Your Role : ");
            int roleChoice = s.nextInt();
            if (roleChoice == 1) {
                Admin_action.adminEntry();
            }
//            for choice 2
            else if (roleChoice == 2) {
                User_action.userEntry();

            }
            else if(roleChoice==3)
            {
                System.exit(1);
            }
            else {
                System.out.println("Enter correct option...");
            }

        }

    }

    public static boolean checkAdmin(String name, String pass)
    {
        if(Admin.getAdminName().equals(name) && Admin.getpin().equals(pass))
        {
            return true;
        }
        return false;
    }

    public static boolean checkUser(String uname, String pin)
    {
        ArrayList<User> usersAvailable = ATM.getAvailableUsers();
        for(User individualUser:usersAvailable)
        {
            if (individualUser.getUserName().equals(uname) && individualUser.getPin().equals(pin))
            {
                return true;
            }
        }
        return false;
    }
    public static User getUser(String uname)
    {
        ArrayList<User> usersAvailable =ATM.getAvailableUsers();
        for(User individualUser:usersAvailable)
        {
            if (individualUser.getUserName().equals(uname))
            {
                return individualUser;
            }
        }
        return null;
    }


}