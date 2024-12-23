package ATM_Console_Application;
//import java.util.Scanner;
import java.util.ArrayList;
public class User {
        private String username;
        private String password;
        private  double balance;
    public static ArrayList<String> trans=new ArrayList<String>();
//        Scanner scan=new Scanner(System.in);

        public void setUsername(String username){
            this.username=username;

        }
    public void setUserpassword(String password){
        this.password=password;
    }
    public String getuser(){
            return username;
        }
    public String getPassword(){
        return password;
    }
    public  double getBalance(){
        return balance;
    }


//    public  double withdraw(double withdrawAmount){
//            balance-=withdrawAmount;
//            return balance;
//    }
//    public  double deposit(double depositAmount){
//        balance+=depositAmount;
//        return balance;
//    }


        @Override
        public String toString(){

            return  this.username+"\n"+this.password;

        }
    }

