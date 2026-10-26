package LAB3.Q14_AutomobileShop;


import java.time.LocalDate;
import java.util.Scanner;

public class AutomobileShopInteractive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutomobileShop shop = new AutomobileShop();

        shop.seedCars();

        int choice;

        do {
            System.out.println("\n--- AUTOMOBILE SHOP ---");
            System.out.println("1. Add new car");
            System.out.println("2. Search for car");
            System.out.println("3. Book car");
            System.out.println("4. Display all cars");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter car name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter car model: ");
                    String model = sc.nextLine();

                    System.out.print("Enter purchase date (yyyy-MM-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    System.out.print("Enter car color: ");
                    String color = sc.nextLine();

                    System.out.print("Enter car price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                    } else {
                        UsedCar added = shop.addCar(
                                name, model, date, color, price);
                        System.out.println("Car added successfully!");
                        System.out.println(added);
                    }
                    break;

                case 2:
                    System.out.print("Enter car name: ");
                    String searchName = sc.nextLine();

                    System.out.print("Enter car model: ");
                    String searchModel = sc.nextLine();

                    UsedCar found = shop.searchCar(searchName, searchModel);

                    if (found == null) {
                        System.out.println("Car not found.");
                    } else {
                        System.out.println(found);
                    }
                    break;

                case 3:
                    System.out.print("Enter car name to book: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter car model: ");
                    String bookModel = sc.nextLine();

                    UsedCar booked = shop.bookCar(bookName, bookModel);

                    if (booked == null) {
                        System.out.println("Car not available.");
                    } else {
                        System.out.println("Car booked successfully!");
                        System.out.println(booked);
                    }
                    break;

                case 4:
                    if (shop.getCars().isEmpty()) {
                        System.out.println("No cars available.");
                    } else {
                        for (UsedCar car : shop.getCars()) {
                            System.out.println(car);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Automobile Shop.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

