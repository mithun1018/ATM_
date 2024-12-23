package ATM_Console_Application;
import java.util.Scanner;

public class User {
        private String username;
        private String password;
        private  double balance=0.0;
        Scanner scan=new Scanner(System.in);

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
    public  double withdraw(double withdrawAmount){
            this.balance-=withdrawAmount;
            return balance;
    }
    public  double deposit(double depositAmount){
        this.balance+=depositAmount;
        return balance;
    }
    public void print(){
            while (true){
                System.out.println("1.check balance\n2.withdraw\n3.deposit\n4.Change pin");
                String userinp=scan.next();
                User user=new User();
                int userinput=Integer.parseInt(userinp);
                if (userinput == 1) {
                    user.getBalance();
                } else if (userinput==2) {
                    System.out.println("enter the withdraw amount");
                    double enterWithdrawAmount=scan.nextDouble();
                    user.withdraw(enterWithdrawAmount);
                }
                else if (userinput==3) {
                    System.out.println("enter the deposit amount");
                    double enterdepositAmount=scan.nextDouble();
                    user.withdraw(enterdepositAmount);
                } else if (userinput==4){
                    System.out.println("enter the current pin:");
                    String currentPin = scan.next();
                    for(User checkPin:Admin.userarray){
                        if(currentPin.equals(checkPin.getPassword())){
                            System.out.println("enter the new pin:");
                            String newPin = scan.next();
                            this.password=newPin;
                        }
                    }

                }
            }


    }

        @Override
        public String toString(){

            return  this.username+"\n"+this.password;

        }
    }

