package ATM_Console_Application;
import java.util.Scanner;
public class Admin_action {

    public static void print() {
        Scanner scan = new Scanner(System.in);

        System.out.println("your choice \n1.Add user Account\n2.Delete your account\n3.View Transaction history\n4.view all user\n5.exit\nEnter your choice:");
        String admin_choice1 = scan.next();
        int admin_choice=Integer.parseInt(admin_choice1);
        if (admin_choice == 1) {
            Admin.add_user();
            Admin_action.print();
        }
        else if (admin_choice==2) {
            Admin.remove_user();
            Admin_action.print();
        }
        else if (admin_choice==3) {
            Admin.transaction();
            Admin_action.print();

        } else if (admin_choice==5) {
            ATM.print();
        }
    }
}
