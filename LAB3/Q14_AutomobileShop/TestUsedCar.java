package LAB3.Q14_AutomobileShop;


import java.time.LocalDate;

public class TestUsedCar {
    public static void main(String[] args) {
        UsedCar car = new UsedCar(
                "Thar", "AX", LocalDate.of(2021, 3, 12),
                "Red", 950000.00);

        System.out.println("--- Testing UsedCar ---");
        System.out.println(car);

        System.out.println("\nTesting getters:");
        System.out.println("Name: " + car.getName());
        System.out.println("Model: " + car.getModel());
        System.out.println("Purchase date: " + car.getYearOfPurchase());
        System.out.println("Color: " + car.getColor());
        System.out.println("Price: " + car.getPrice());

        System.out.println("\nTesting setters:");
        car.setName("Thar Updated");
        car.setModel("LX");
        car.setYearOfPurchase(LocalDate.of(2022, 4, 18));
        car.setColor("Black");
        car.setPrice(1020000.00);

        System.out.println(car);
    }
}

