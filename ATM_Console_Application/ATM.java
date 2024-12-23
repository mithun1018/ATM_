package ATM_Console_Application;

import java.util.Scanner;

public class ATM {
  public void print(){
      Scanner scan = new Scanner(System.in);

      label: while(true) {
          System.out.println("are you a user or admin\n1.User\n2.Admin\nenter your access:");
          String access_inp1 = scan.next();
          int access_inp = Integer.parseInt(access_inp1);
          if(access_inp==1){
              System.out.println("enter user name:");
              String enterUserName=scan.next();
              System.out.println("enter user password:");
              String enterUserPassword=scan.next();
              for(User usercheck:Admin.userarray){
                  if(enterUserName.equals(usercheck.getuser())&& enterUserPassword.equals(usercheck.getPassword())){
                      User user=new User();
                      user.print();

                  }
              }
          }
          else if (access_inp == 2) {
              System.out.println("enter your Admin id:");
              String input_id = scan.next();
              //int x=Integer.parseInt(variable);
              // nextline ->  int Integer.parseInt() //wrapper
              if (input_id.equals(Admin_info.getAdmin_id())) {
                  int j=0;
                  while (j<=2) {
                      Scanner s1 = new Scanner(System.in);
                      System.out.println("enter your Admin pin:");
                      String input_pin = s1.nextLine();
                      if (input_pin.equals(Admin_info.getAdmin_pin()))
                      {
                          Admin admin=new Admin();
                          admin.print();
                          j=3;
                          continue label;                            }
                      else {
                          System.out.println("wrong pin");
                          j++;
                      }
                  }
              }
              else{
                  System.out.println("invalid id");
                  continue;
              }
          }
      }
  }
}
