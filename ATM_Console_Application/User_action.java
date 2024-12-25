package ATM_Console_Application;
import java.util.Scanner;
import java.util.ArrayList;


public class User_action {
    public static void userEntry()
    {
        Scanner s = new Scanner(System.in);
        if (!ATM.getAvailableUsers().isEmpty()) {
            userEnter:
            while (true) {
                System.out.print("Enter the User name: ");
                String userName = s.nextLine();
                System.out.print("Enter the Pin: ");
                String pinNo = s.nextLine();

                if (ATM.checkUser(userName, pinNo)) {
                    User currentUser = ATM.getUser(userName);
                    System.out.println("User Login Success..");
                    while (true) {
                        System.out.println("Enter the Operation to do..");
                        System.out.println(" \n 1. Check Balance  \n 2. Withdraw Cash \n 3. Deposit Cash \n 4. Show History \n5. Change Pin \n 6. Logout");
                        int operationChoice = Integer.parseInt(s.nextLine());

                        if (operationChoice == 1)
                        {
                            System.out.println("Your current balance is " + currentUser.getBalance());
                        }
                        else if (operationChoice == 2)
                        {
                            User_action.withdrawCash(s,currentUser);

                        }
                        else if (operationChoice == 3)
                        {

                            User_action.depositCash(s,currentUser);
                        }
                        else if (operationChoice == 4)
                        {
                            User_action.viewTransactions(currentUser);
                        }
                        else if (operationChoice == 5)
                        {
                            User_action.changePin(s,currentUser);
                        }
                        else if (operationChoice == 6)
                        {
                            System.out.println("Exit");
                            break userEnter;
                        }
//                        more operations need to be added here
                        else
                        {
                            System.out.println("Enter the correct option");
                        }

                    }
                }
                else
                {
                    System.out.println("The entered credentials are wrong...Try Again");
                }
            }
        }
        else
        {
            System.out.println("No User found...Try contacting the Admin");
        }
    }
    public static void changePin(Scanner s,User currentUser)
    {
        System.out.print("Enter the Pin to change :");
        String pin = s.nextLine();
        currentUser.setPin(pin);
        System.out.println("Pin changed");
    }

    public static void withdrawCash(Scanner s,User currentUser )
    {
        System.out.print("Enter the withdraw amount : ");
        long Withdrawamount = Long.parseLong(s.nextLine());
            if (Withdrawamount <= currentUser.getBalance()) {
                System.out.println("the Withdrawl amount :." + Withdrawamount + " is successful");
                double currentBalanceInAcc = currentUser.getBalance() - Withdrawamount;
                double currentBalanceInATM = ATM.getBalance() - Withdrawamount;
                currentUser.setBalance(currentBalanceInAcc);
                ATM.setBalance(currentBalanceInATM);
                currentUser.addUserTransactionHistory("Your account is debited with Rs." + Withdrawamount + "--- Balance :" + currentUser.getBalance());
                Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is debited with Rs." + Withdrawamount + "--- User Balance : " + currentUser.getBalance() );
                System.out.println("Your balance is " + currentUser.getBalance());
            } else {
                System.out.println(" sufficent balance");
            }


    }

    public static void depositCash(Scanner s,User currentUser)
    {
        System.out.print("Enter the deposit amount : ");
        long Depositamount = Long.parseLong(s.nextLine());
        double currentBalance = currentUser.getBalance() + Depositamount;
        double balanceInAtm = ATM.getBalance() + Depositamount;
        currentUser.setBalance(currentBalance);
        ATM.setBalance(balanceInAtm);
        currentUser.addUserTransactionHistory("Your account is credited with Rs." + Depositamount + "--- Balance :" + currentUser.getBalance());
        Admin.addATMTransactionHistory(currentUser.getUserName() + "'s account is credited with Rs." + Depositamount + "--- User Balance : " + currentUser.getBalance() + "--- ATM Balance : " + ATM.getBalance());
        System.out.println("The deposit of Rs." + Depositamount + " is added successfully");
        System.out.println("Your current balance is " + currentUser.getBalance());
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