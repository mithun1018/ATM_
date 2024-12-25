package ATM_Console_Application;
import java.util.ArrayList;
import java.util.Scanner;


public class ATM
{
    private static ArrayList<User> userArray = new ArrayList<>();
    private static ArrayList<Admin> adminArray = new ArrayList<>();
    private static double balance;
    public static ArrayList<User> getAvailableUsers()
    {
        return userArray;
    }

    public static ArrayList<Admin> getAvailableAdmin()
    {
        return adminArray;
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
            System.out.println("1.Admin\n2.User\n3.Exit\nEnter your choice : ");
            int roleChoice = Integer.parseInt(s.next());
            if (roleChoice == 1) {
                ATM.adminArray.add(new Admin("123","1234"));
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
public static void adminAction(Scanner scan){
    while (true) {
        System.out.println("1.Add User\n2.Delete User\n3.View all user\n4.transaction history\n5.Add a New Admin\n 6.exit\nEnter the operation");
        int adminchoice = Integer.parseInt(scan.next());
        if (adminchoice == 1) {
            Admin_action.addUser(scan);
        } else if (adminchoice == 2) {
            Admin_action.deleteUser(scan);
        } else if (adminchoice == 3) {
            Admin_action.viewAllUse();

        }
        else if (adminchoice==4) {
            Admin_action.transactionhistory();
        } else if (adminchoice==5) {
            Admin_action.addAdmin(scan);

        } else if (adminchoice == 6) {
            System.out.println("Exit");
            ATM.start();
//                        break adminPassEnter;
        } else {
            System.out.println("invalid input");
        }
    }
}
public static void userAction(Scanner scan,User currentUser){
    while (true) {
        System.out.println("Enter the Operation to do..");
        System.out.println(" \n 1. Check Balance  \n 2. Withdraw Cash \n 3. Deposit Cash \n 4. Show History \n5. Change Pin \n 6. Logout");
        int operationChoice = Integer.parseInt(scan.nextLine());

        if (operationChoice == 1)
        {
            System.out.println("Your current balance is " + currentUser.getBalance());
        }
        else if (operationChoice == 2)
        {
            User_action.withdrawCash(scan,currentUser);

        }
        else if (operationChoice == 3)
        {

            User_action.depositCash(scan,currentUser);
        }
        else if (operationChoice == 4)
        {
            User_action.viewTransactions(currentUser);
        }
        else if (operationChoice == 5)
        {
            User_action.changePin(scan,currentUser);
        }
        else if (operationChoice == 6)
        {
            System.out.println("Exit");
//                            break userEnter;
            ATM.start();
        }
        else
        {
            System.out.println("Enter the correct option");
        }

    }
}



    public static User getUser(String username)
    {
        ArrayList<User> usersAvailable =ATM.getAvailableUsers();
        for(User individualUser:usersAvailable)
        {
            if (individualUser.getUserName().equals(username))
            {
                return individualUser;
            }
        }
        return null;
    }
    public static Admin getAdmin(String adminname)
    {
        ArrayList<Admin> AdminsAvailable =ATM.getAvailableAdmin();
        for(Admin individualAdmin:AdminsAvailable)
        {
            if (individualAdmin.getAdminName().equals(adminname))
            {
                return individualAdmin;
            }
        }
        return null;
    }

}