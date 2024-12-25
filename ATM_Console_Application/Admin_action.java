package ATM_Console_Application;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_action {
    public static void adminEntry() {
        adminPassEnter:
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the Admin name: ");
            String adminName = s.nextLine();
            System.out.print("Enter the Password: ");
            String password = s.nextLine();
            if (ATM.checkAdmin(adminName, password)) {
                while (true) {
                    System.out.println("  1. Add User \n 2. Delete User\n 5. Logout\nEnter the operation");
                    int operationChoice = Integer.parseInt(s.nextLine());
                    if (operationChoice == 1) {
                        Admin_action.addUser(s);
                    } else if (operationChoice == 2) {
                        Admin_action.deleteUser(s);
                    } else if (operationChoice == 5) {
                        System.out.println("Exit");
                        break adminPassEnter;
                    } else {
                        System.out.println("Enter the correct option");
                    }
                }
            } else {
                System.out.println("The entered credentials are wrong..\n Enter again.");
            }
        }

    }

    public static void addUser(Scanner s) {
        System.out.print("Enter the User's Name to Add :");
        String userName = s.nextLine();
        System.out.println("enter the password");
        String userpin = s.nextLine();
        System.out.println("User Added Successfully..");
        ATM.getAvailableUsers().add(new User(userName, userpin, 5000));
    }

    public static void deleteUser(Scanner s) {
        ArrayList<User> usersToRemove = ATM.getAvailableUsers();
        if (!usersToRemove.isEmpty()) {
            System.out.println("The Users are...");
            int i = 1;
            for (User temp : usersToRemove) {
                System.out.println(i + " - " + temp.getUserName());
                i++;
            }
            System.out.print("Enter the Id no of the User to remove :");
            int removeChoice = Integer.parseInt(s.nextLine());
            ATM.getAvailableUsers().remove(removeChoice - 1);
            System.out.println("User Successfully Removed...");
        } else {
            System.out.println("No users available..Add user and try again..");
        }
    }

    public static void viewAllUse(Scanner s) {
        ArrayList<User> allusers = ATM.getAvailableUsers();
        if (!allusers.isEmpty()) {
            System.out.println("The Users are...");
            int i = 1;
            for (User temp : allusers) {
                System.out.println(i + " - " + temp.getUserName());
                i++;
            }
        }
        else {
            System.out.println("it is empty");
        }


    }
}
