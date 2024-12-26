package ATM_Console_Application;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userName;
    private String pin;
    private double accBalance;
//    private ArrayList<String> userHistory = new ArrayList<String>();


    public User(String userName, String pin)
    {
        this.setUserName(userName);
        this.setPin(pin);
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPin()
    {
        return pin;
    }
    public void setPin(String pin)
    {
        this.pin = pin;
    }
    public double getBalance()
    {
        return accBalance;
    }
    public void setBalance(double balance)
    {
        this.accBalance = balance;
    }
//    public void addUserTransactionHistory(String transaction)
//    {
//        this.userHistory.add(transaction);
//    }
//
//    public ArrayList<String> getUserTransactionHistory()
//    {
//        return this.userHistory;
//    }


}