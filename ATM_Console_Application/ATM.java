package ATM_Console_Application;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static ArrayList<User> userarray = new ArrayList<User>();
  public static void print(){
      Scanner scan = new Scanner(System.in);

      label: while(true) {
          System.out.println("are you a user or admin\n1.User\n2.Admin\n3.exit\nenter your access:");
          String access_inp1 = scan.next();
          int access_inp = Integer.parseInt(access_inp1);
          if(access_inp==1){
              System.out.println("enter user name:");
              String enterUserName=scan.next();
              System.out.println("enter user password:");
              String enterUserPassword=scan.next();
              User_action userAction=new User_action();
              String name=userAction.getuser();
              if(enterUserName.equals(name)){
                  userAction.print();
              }
              else {
                  System.out.println("invalid user");
              }


//              if(Admin.userarray.isEmpty()){
//                  System.out.println("it is empty you should create and account");
//                  Admin.add_user();
//              }
//              for(User usercheck:Admin.userarray){
//                  if(enterUserName.equals(usercheck.getuser())&& enterUserPassword.equals(usercheck.getPassword())){
//                      User user=new User();
//
//                  }
//                  else{
//                      System.out.println("invalid user");
//                      User_action userAction=new User_action();
//                      userAction.print();
//                  }
              }

          else if (access_inp == 2) {
              System.out.println("enter your Admin id:");
              String input_id = scan.next();
              //int x=Integer.parseInt(variable);
              // nextline ->  int Integer.parseInt() //wrapper
              if (input_id.equals(Admin.getAdmin_id())) {
                  int j = 0;
                  while (j <= 2) {
                      Scanner s1 = new Scanner(System.in);
                      System.out.println("enter your Admin pin:");
                      String input_pin = s1.nextLine();
                      if (input_pin.equals(Admin.getAdmin_pin())) {
                          Admin admin = new Admin();
                          Admin_action.print();
                          j = 3;
                          continue label;
                      } else {
                          System.out.println("wrong pin");
                          j++;
                      }
                  }
              } else {
                  System.out.println("invalid id");
                  continue;
              }
          }
          else if (access_inp==3) {
              System.exit(0);

          }
          else {
              System.out.println("invalid input");
              continue ;
          }
      }
      }
  }

