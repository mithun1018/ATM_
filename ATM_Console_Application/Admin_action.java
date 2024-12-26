package ATM_Console_Application;
import ATM_Console_Application.Notes.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin_action {

    public static Admin adminEntry() {

//        adminPassEnter:
        label:
        while (true) {
            int i = 1;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter Admin name: ");
            String adminName = scan.nextLine();
            if (Admin_action.checkAdminName(adminName)) {
                while (i <= 3) {
                    System.out.print("Enter Password: ");
                    String password = scan.nextLine();
                    if (Admin_action.checkAdminpin(password)) {
                        Admin currentAdmin = ATM.getAdmin(adminName);
                        ATM.adminAction(scan, currentAdmin);
                    } else {
                        System.out.println("wrong password\ntry again....");
                        i++;
                    }
                }
                ATM.start();

            } else {
                System.out.println("enter the correct admin name");
            }


        }

    }

    public static boolean checkAdminName(String name) {

        {
            ArrayList<Admin> adminsAvailable = ATM.getAvailableAdmin();
            for (Admin individualAdmin : adminsAvailable) {
                if (individualAdmin.getAdminName().equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean checkAdminpin(String pass) {

        {
            ArrayList<Admin> adminsAvailable = ATM.getAvailableAdmin();
            for (Admin individualAdmin : adminsAvailable) {
                if (individualAdmin.getpin().equals(pass)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void addAdmin(Scanner scan) {
        System.out.print("Enter Admin Name :");
        String adminName = scan.next();
        System.out.println("enter password");
        String Adminpin = scan.next();

        System.out.println("successfull new Admin added");
        ATM.getAvailableAdmin().add(new Admin(adminName, Adminpin));
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

    public static void depositInATM(Scanner scan) {
        System.out.println("enter the amount to deposit in ATM: ");
        long depositAmountInATM = Long.parseLong(scan.next());
        System.out.println("enter the no of notes to deposit....");
        System.out.println("enter the no.of 2000: ");
        int twoThousandNotes = Integer.parseInt(scan.next());
        System.out.println("enter the no.of 500: ");
        int fiveHundredNotes = Integer.parseInt(scan.next());
        System.out.println("enter the no.of 200: ");
        int twoHundredNotes = Integer.parseInt(scan.next());
        System.out.println("enter the no.of 100: ");
        int oneHundredNotes = Integer.parseInt(scan.next());
        long depositAmountInATMInNotes = 2000 * twoThousandNotes + 500 * fiveHundredNotes + 200 * twoHundredNotes + 100 * oneHundredNotes;
        if (depositAmountInATM == depositAmountInATMInNotes) {
            for (Notes availableNotes : ATM.getAvailableNotes()) {
                switch (availableNotes.getNotes()) {
                    case "2000":
                        availableNotes.setCount(availableNotes.getCount() + twoThousandNotes);
                    case "500":
                        availableNotes.setCount(availableNotes.getCount() + fiveHundredNotes);
                    case "200":
                        availableNotes.setCount(availableNotes.getCount() + twoThousandNotes);
                    case "100":
                        availableNotes.setCount(availableNotes.getCount() + oneHundredNotes);
                }

            }
            ATM.setBalance(ATM.getBalance() + depositAmountInATM);
            ATM.getAvailableTransaction().add(new Transaction("Admin", "deposited rs: ", depositAmountInATM));
//            Admin.addATMTransactionHistoryForAdmin("the admin add the amount of "+depositAmountInATM+" in ATM");
            System.out.println("successfully rs." + depositAmountInATM + " is deposited in ATM");
        }

    }

    public static void viewAmountInATM() {
        System.out.println("the amount in ATM :" + ATM.getBalance());
    }

    public static void transactionhistory(Scanner scan) {
        System.out.println("1.Admin trancations\n2.User trancations\nEnter your choice: ");
        int choice = Integer.parseInt(scan.next());
        if (choice == 1) {
            for (Transaction temp : ATM.getAvailableTransaction()) {
                if (!temp.getPerformedBy().equals("Admin")) {
                    System.out.println(temp.getTransaction());
                } else {
                    return;
                }
            }

        } else if (choice == 2) {
            for (Transaction temp : ATM.getAvailableTransaction()) {
                if (temp.getPerformedBy().equals("Admin")) {
                    System.out.println(temp.getTransaction());
                }
            }
        } else {
            System.out.println("invalid input");
        }
    }
}

