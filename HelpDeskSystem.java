import java.util.Scanner;
public class MiniHelpdesk {
    static String user, issue, status = "Open";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- MINI HELP DESK ---");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Update Status");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("User Name: ");
                user = sc.nextLine();
                System.out.print("Issue: ");
                issue = sc.nextLine();
                status = "Open";
                System.out.println("Ticket Created!");
            }
            else if (choice == 2) {
                System.out.println("User   : " + user);
                System.out.println("Issue  : " + issue);
                System.out.println("Status : " + status);
            }
            else if (choice == 3) {
                System.out.print("New Status: ");
                status = sc.nextLine();
                System.out.println("Status Updated!");
            }
        }
        while (choice != 4);
        sc.close();
    }
}
