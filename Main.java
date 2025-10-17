import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===== 📚 Library Management System =====");

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    manager.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    manager.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    manager.returnBook(returnId);
                    break;
                case 4:
                    manager.viewBooks();
                    break;
                case 0:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
