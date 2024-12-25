package ATM_Console_Application;
import java.util.Scanner;
import java.util.ArrayList;


public class User_action {
    public static void userEntry()
    {
        Scanner scan = new Scanner(System.in);
        int i=1;
        if (!ATM.getAvailableUsers().isEmpty()) {
            userEnter:
            while (true) {
                System.out.print("Enter the User name: ");
                String userName = scan.nextLine();
                if(User_action.checkUserName(userName)){
                    while (i<=3){
                        System.out.print("Enter the Pin: ");
                        String pinNo = scan.nextLine();
                        if (User_action.checkUserPin(pinNo)){
                            User currentUser = ATM.getUser(userName);
                            System.out.println("User Login Success..");
                            ATM.userAction(scan,currentUser);
                        }
                        else {
                            System.out.println("enter the correct pin\ntry again....");
                            i++;

                        }
                    }
                    ATM.start();

                }

                else
                {
                    System.out.println("Try Again");
                }
            }
        }
        else
        {
            System.out.println("No User found");
        }
    }
    public static boolean checkUserName(String uname)
    {
        ArrayList<User> usersAvailable = ATM.getAvailableUsers();
        for(User individualUser:usersAvailable)
        {
            if (individualUser.getUserName().equals(uname) )
            {
                return true;
            }
        }
        return false;
    }
    public static boolean checkUserPin( String pin)
    {
        ArrayList<User> usersAvailable = ATM.getAvailableUsers();
        for(User individualUser:usersAvailable)
        {
            if ( individualUser.getPin().equals(pin))
            {
                return true;
            }
        }
        return false;
    }
    public static void changePin(Scanner s,User currentUser)
    {
        System.out.print("Enter Pin to change :");
        String pin = s.nextLine();
        currentUser.setPin(pin);
        System.out.println("Pin changed");
    }

    public static void withdrawCash(Scanner s,User currentUser )
    {
        System.out.print("Enter the withdraw amount : ");
        long Withdrawamount = Long.parseLong(s.nextLine());
            if (Withdrawamount <= currentUser.getBalance()) {
                System.out.println("the Withdrawl amount :" + Withdrawamount + " is successful");
                double currentBalanceInAcc = currentUser.getBalance() - Withdrawamount;
                currentUser.setBalance(currentBalanceInAcc);
                currentUser.addUserTransactionHistory("Your account is debited with Rs." + Withdrawamount + "Balance :" + currentUser.getBalance());
                Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is debited with Rs." + Withdrawamount + "--- User Balance : " + currentUser.getBalance() );
                System.out.println("balance is " + currentUser.getBalance());
            } else {
                System.out.println(" Insufficent balance");
            }


    }

    public static void depositCash(Scanner s,User currentUser)
    {
        System.out.print("Enter the deposit amount : ");
        long Depositamount = Long.parseLong(s.nextLine());
        double currentBalance = currentUser.getBalance() + Depositamount;
        currentUser.setBalance(currentBalance);
        currentUser.addUserTransactionHistory("Your account is credited with Rs." + Depositamount + "    Balance :" + currentUser.getBalance());
        Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is credited with Rs." + Depositamount + "   User Balance : " + currentUser.getBalance() + "--- ATM Balance : " + ATM.getBalance());
        System.out.println("The deposit of Rs." + Depositamount + " is added successfully");
        System.out.println("current balance is " + currentUser.getBalance());
    }

    public static void viewTransactions(User currentUser)
    {
        ArrayList<String> userHistory = currentUser.getUserTransactionHistory();
        if (!userHistory.isEmpty()) {
            System.out.println("The Transactions are\n");
            for (String history : userHistory) {
                System.out.println(history);
            }
        } else {
            System.out.println("There are no Transactions..");
        }
    }

}