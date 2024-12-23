package ATM_Console_Application;
import java.util.Scanner;
public class User_action extends User{
    Scanner scan=new Scanner(System.in);
    public void print(){
        while (true){

            System.out.println("1.check balance\n2.withdraw\n3.deposit\n4.Change pin\n5.view transaction history");
            String userinp=scan.next();
            User user=new User();
            int userinput=Integer.parseInt(userinp);
            if (userinput == 1) {
                System.out.println(user.getBalance());
            } else if (userinput==2) {
                System.out.println("enter the withdraw amount");
                double enterWithdrawAmount=scan.nextDouble();
                double totalBalance=getBalance();
                double balanceAmount=totalBalance-enterWithdrawAmount;
                String Trans_inp=user.getuser()+"withdraw -"+enterWithdrawAmount;
                trans.add(Trans_inp);
                System.out.println(balanceAmount);
            }
            else if (userinput==3) {
                System.out.println("enter the deposit amount");
                double enterdepositAmount=scan.nextDouble();
                double totalBalance=getBalance();
                double balanceAmount=totalBalance-enterdepositAmount;
                String Trans_inp=user.getuser()+"deposits -"+enterdepositAmount;
                trans.add(Trans_inp);
                System.out.println(balanceAmount);
            }
            else if (userinput==4){
                System.out.println("enter the current pin:");
                String currentPin = scan.next();
                for(User checkPin:ATM.userarray){
                    if(currentPin.equals(checkPin.getPassword())){
                        System.out.println("enter the new pin:");
                        String newPin = scan.next();
                        setUserpassword(newPin);
                        System.out.println("successfully pin changed");
                    }
                }

            } else if (userinput==5) {
                System.out.println(trans);

            }
        }


    }
}
