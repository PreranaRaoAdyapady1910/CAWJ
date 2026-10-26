package LAB3.Q13_BookShop;


import java.util.Scanner;

public class TestBookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookShop shop = new BookShop();

        shop.seedBooks();

        int choice;

        do {
            System.out.println("\n--- BOOK SHOP ---");
            System.out.println("1. Add new book");
            System.out.println("2. Search for book");
            System.out.println("3. Process order");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter publisher: ");
                    String publisher = sc.nextLine();

                    System.out.print("Enter stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    if (price < 0 || stock < 0) {
                        System.out.println("Price and stock cannot be negative.");
                    } else {
                        Book added = shop.addBook(
                                title, author, price, publisher, stock);
                        System.out.println("Book added successfully.");
                        System.out.println(added);
                    }
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    String searchTitle = sc.nextLine();

                    System.out.print("Enter author: ");
                    String searchAuthor = sc.nextLine();

                    Book found = shop.searchBook(searchTitle, searchAuthor);

                    if (found == null) {
                        System.out.println("Book is not available.");
                    } else {
                        System.out.println(found);
                    }
                    break;

                case 3:
                    System.out.print("Enter title: ");
                    String orderTitle = sc.nextLine();

                    System.out.print("Enter author: ");
                    String orderAuthor = sc.nextLine();

                    System.out.print("Enter number of copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    shop.processTransaction(orderTitle, orderAuthor, copies);
                    break;

                case 4:
                    for (Book book : shop.getAllBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 5:
                    System.out.println("Exiting Book Shop.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
