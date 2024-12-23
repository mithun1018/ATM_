package ATM_Console_Application;
import java.util.Scanner;
import java.util.ArrayList;
public class Admin {
        public static ArrayList<User> userarray = new ArrayList<User>();
        Scanner scan = new Scanner(System.in);

        public void print() {

            System.out.println("your choice \n1.Add user Account\n2.Delete your account\n3.View Transaction history\nEnter your choice:");
            String admin_choice1 = scan.next();
            int admin_choice=Integer.parseInt(admin_choice1);
            if (admin_choice == 1) {
                Admin.add_user();
            }
        }
        public static void add_user() {
            Scanner scan = new Scanner(System.in);

            User user = new User();
            System.out.println("enter user name");
            String enterUsername = scan.next();
            System.out.println("enter user pin");
            String enterUserpin=scan.next();
            for(User checkuser:userarray){
                String checkUserName= user.getuser();
                if(checkUserName.equals(enterUsername)){
                    System.out.println("already exist");

                }
                else{
                    user.setUsername(enterUsername);
                    user.setUserpassword(enterUserpin);
                    userarray.add(user);
//                    System.out.println(checkuser.toString());

                }
            }

//            System.exit(0);
        }
    public static void remove_user(){
        Scanner scan = new Scanner(System.in);

        User user = new User();
        System.out.println("enter user name");
        String enterUsername = scan.next();
        System.out.println("enter user pin");
        String enterUserpin=scan.next();
        for(User checkuser:userarray){
            String checkUserName= user.getuser();
            if(checkuser.equals(enterUsername)){
                userarray.remove(checkuser);
                System.out.println("user "+userarray.toString());
            }
            else{
                System.out.println("not exist");

            }
        }

    }
    }

