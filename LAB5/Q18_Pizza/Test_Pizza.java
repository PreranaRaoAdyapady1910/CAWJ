package LAB5.Q18_Pizza;

public class Test_Pizza {
    public static void main(String[] args) {
        testCirclePizza();
        testRectanglePizza();

        System.out.println("All pizza tests passed!");
    }

    public static void testCirclePizza() {
        Circle circle = new Circle(4);
        Pizza pizza = new Pizza(120.50, circle);

        assert pizza.getPrice() == 120.50;
        assert pizza.getShape() instanceof Circle;
        assert pizza.getShape().getArea() == 50.27;
        assert ((Circle) pizza.getShape()).getRadius() == 4;
    }

    public static void testRectanglePizza() {
        Rectangle rectangle = new Rectangle(5, 8);
        Pizza pizza = new Pizza(180.00, rectangle);

        assert pizza.getPrice() == 180.00;
        assert pizza.getShape() instanceof Rectangle;
        assert pizza.getShape().getArea() == 40.0;
        assert ((Rectangle) pizza.getShape()).getHeight() == 5;
        assert ((Rectangle) pizza.getShape()).getWidth() == 8;
    }
}