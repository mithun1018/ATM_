package ATM_Console_Application;
import java.util.Scanner;
import java.util.ArrayList;
public class Admin {
    Scanner scan = new Scanner(System.in);
    private static final String admin_id="123";
    private static final String admin_pin="1234";

    public static String  getAdmin_id(){
        return admin_id;
    }
    public static String getAdmin_pin(){
        return admin_pin;
    }

    public static void add_user() {
            Scanner scan = new Scanner(System.in);

            User user = new User();
            System.out.println("enter user name");
            String enterUsername = scan.next();
            System.out.println("enter user pin");
            String enterUserpin=scan.next();
            if(ATM.userarray.isEmpty()){
//                System.out.println("it is empty");
                user.setUsername(enterUsername);
                user.setUserpassword(enterUserpin);
                ATM.userarray.add(new User());
                System.out.println("successfully new user added");
//                user.toString();
            }
//            else {
//                for (User checkuser : userarray) {
//                    String checkUserName = checkuser.getuser();
//                    if (checkUserName.equals(enterUsername)) {
//                        System.out.println("already exist");
//
//                    } else {
//                        user.setUsername(enterUsername);
//                        user.setUserpassword(enterUserpin);
//                        userarray.add(user);
//                        System.out.println("successfully new user added");
////                    System.out.println(checkuser.toString());
//
//                    }
//                }
//            }
            else {
                System.out.println("the list is empty");
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
        for(User checkuser:ATM.userarray){
            String checkUserName= user.getuser();
            if(checkUserName.equals(enterUsername)){
                ATM.userarray.remove(checkuser);
                System.out.println("successfully removed");
//                System.out.println("user "+userarray.toString());
            }
            else{
                System.out.println("not exist");

            }
        }

    }
    public static void transaction(){
//        for ()
        User.trans.get(0);
    }

    }

