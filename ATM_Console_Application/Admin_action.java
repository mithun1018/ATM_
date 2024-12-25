package ATM_Console_Application;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_action {

    public static Admin adminEntry() {

//        adminPassEnter:
        label: while (true) {
            int i=1;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter Admin name: ");
            String adminName = scan.nextLine();
            if(Admin_action.checkAdminName(adminName)){
                while (i<=3){
                    System.out.print("Enter Password: ");
                    String password = scan.nextLine();
                    if (Admin_action.checkAdminpin(password)){
                        return Admin;
                    }
                    else {
                        System.out.println("wrong password\ntry again....");
                        i++;
                    }
                }
                ATM.start();

            }else {
                System.out.println("enter the correct admin name");
            }




        }

    }

    public static boolean checkAdminName(String name) {

        {
            ArrayList<Admin> adminsAvailable = ATM.getAvailableAdmin();
//            adminsAvailable.add(new Admin("123","1234"));
            for(Admin individualAdmin:adminsAvailable)
            {
                if (individualAdmin.getAdminName().equals(name))
                {
                    return true;
                }
            }
            return false;
        }
    }
    public static boolean checkAdminpin( String pass) {

        {
            ArrayList<Admin> adminsAvailable = ATM.getAvailableAdmin();
            for(Admin individualAdmin:adminsAvailable)
            {
                if (individualAdmin.getpin().equals(pass))
                {
                    return true;
                }
            }
            return false;
        }
    }
public static void addAdmin(Scanner scan){
    System.out.print("Enter Admin Name :");
    String adminName = scan.next();
    System.out.println("enter password");
    String Adminpin = scan.next();

    System.out.println("successfull new Admin added");
    ATM.getAvailableAdmin().add(new Admin(adminName,Adminpin));
}
    public static void addUser(Scanner scan) {

        System.out.print("Enter User Name :");
        String userName = scan.next();
        System.out.println("enter password");
        String userpin = scan.next();

        System.out.println("User Added Successfully");
        ATM.getAvailableUsers().add(new User(userName, userpin));
    }

    public static void deleteUser(Scanner scan) {
        ArrayList<User> usersToRemove = ATM.getAvailableUsers();
        if (!usersToRemove.isEmpty()) {
            System.out.println("The Users are...");
            int i = 1;
            for (User temp : usersToRemove) {
                System.out.println(i + " - " + temp.getUserName());
                i++;
            }
            System.out.print("Enter the Id no of the User to remove :");
            int removeChoice = Integer.parseInt(scan.next());
            ATM.getAvailableUsers().remove(removeChoice - 1);
            System.out.println("User Successfully Removed...");
        } else {
            System.out.println("No users available..Add user and try again..");
        }
    }

    public static void viewAllUse() {
        ArrayList<User> allusers = ATM.getAvailableUsers();
        if (!allusers.isEmpty()) {
            System.out.println("The Users are...");
            int i = 1;
            for (User temp : allusers) {
                System.out.println(i + " - " + temp.getUserName());
                i++;
            }
        } else {
            System.out.println("it is empty");
        }


    }

    public static void transactionhistory() {

            System.out.println("The trancations are...");
            int i = 1;
            for (String temp : Admin.AtmTransactionHistory()) {
                System.out.println(i + " - " + temp);
                i++;
            }
        }


    }

