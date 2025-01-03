package ATM_Console_Application;
import ATM_Console_Application.Notes.Notes;

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
                String userName = scan.next();
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
    public static void changePin(Scanner scan,User currentUser)
    {
        System.out.print("Enter Pin to change :");
        String pin = scan.nextLine();
        currentUser.setPin(pin);
        System.out.println("Pin changed");
    }

    public static void withdrawCash(Scanner scan,User currentUser )
    {
        System.out.print("Enter the withdraw amount : ");
        long Withdrawamount = Long.parseLong(scan.next());
        if(Withdrawamount<=ATM.getBalance()) {
            if (Withdrawamount <= currentUser.getBalance()) {
                System.out.println("the Withdrawl amount :" + Withdrawamount + " is successful");
                double currentBalanceInAcc = currentUser.getBalance() - Withdrawamount;
                double currentBalanceInATM = ATM.getBalance() - Withdrawamount;
                currentUser.setBalance(currentBalanceInAcc);
                ATM.getAvailableTransaction().add(new Transaction(currentUser.getUserName(),"Withdraw rs: ",Withdrawamount));
//                currentUser.addUserTransactionHistory("Your account is debited with Rs." + Withdrawamount + "Balance :" + currentUser.getBalance());
//                Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is debited with Rs." + Withdrawamount + "--- User Balance : " + currentUser.getBalance());
                System.out.println("balance is " + currentUser.getBalance());
            } else {
                System.out.println(" Insufficent balance");
            }
        }
        else {
            System.out.println("Insufficent balance in ATM \ncome back later");
        }

    }

    public static void depositCash(Scanner scan,User currentUser)
    {

        System.out.print("Enter the deposit amount : ");
        long Depositamount = Long.parseLong(scan.next());
        System.out.println("enter the no of notes to deposit....");
        System.out.println("enter the no.of 2000: ");
        int twoThousandNotes=Integer.parseInt(scan.next());

        System.out.println("enter the no.of 500: ");

        int fiveHundredNotes=Integer.parseInt(scan.next());
        System.out.println("enter the no.of 200: ");

        int twoHundredNotes=Integer.parseInt(scan.next());
        System.out.println("enter the no.of 100: ");

        int oneHundredNotes=Integer.parseInt(scan.next());
        long DepositamountInNotes=2000*twoThousandNotes+500*fiveHundredNotes+200*twoHundredNotes+100*oneHundredNotes;
        if(Depositamount==DepositamountInNotes){
            double currentBalance = currentUser.getBalance() + Depositamount;
//            double currentBalanceInATM= ATM.getBalance()+Depositamount;
            currentUser.setBalance(currentBalance);
            for (Notes availableNotes:ATM.getAvailableNotes()){
                switch(availableNotes.getNotes()){
                    case "2000":
                        availableNotes.setCount(availableNotes.getCount()+twoThousandNotes);
                    case "500":
                        availableNotes.setCount(availableNotes.getCount()+fiveHundredNotes);
                    case "200":
                        availableNotes.setCount(availableNotes.getCount()+twoThousandNotes);
                    case "100":
                        availableNotes.setCount(availableNotes.getCount()+oneHundredNotes);
                }

            }
            ATM.getAvailableTransaction().add(new Transaction(currentUser.getUserName(),"deposited rs: ",Depositamount));
//            currentUser.addUserTransactionHistory("Your account is credited with Rs." + Depositamount + "    Balance :" + currentUser.getBalance());
//            Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is credited with Rs." + Depositamount + "   User Balance : " + currentUser.getBalance() + "--- ATM Balance : " + ATM.getBalance());
            System.out.println("The deposit of Rs." + Depositamount + " is added successfully");
            System.out.println("current balance is " + currentUser.getBalance());
            ATM.userAction(scan,currentUser);
        }

    }

    public static void viewTransactions(User currentUser)
    {
        for (Transaction temp:ATM.getAvailableTransaction()){
            if(currentUser.getUserName().equals(temp.getPerformedBy())){
                System.out.println(temp.getTransaction());
            }else {
                return;
            }
        }
//        ArrayList<String> userHistory = currentUser.getUserTransactionHistory();
//        if (!userHistory.isEmpty()) {
//            System.out.println("The Transactions are\n");
//            for (String history : userHistory) {
//                System.out.println(history);
//            }
//        } else {
//            System.out.println("There are no Transactions..");
//        }
    }

}