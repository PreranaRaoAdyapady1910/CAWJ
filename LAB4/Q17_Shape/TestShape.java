package LAB4.Q17_Shape;

public class TestShape {
    public static void main(String[] args) {

        Shape shapeA = new Shape();

        assert shapeA.getColor().equals("green");
        assert shapeA.isFilled();

        shapeA.setColor("blue");
        shapeA.setFilled(false);

        assert shapeA.getColor().equals("blue");
        assert !shapeA.isFilled();
        assert shapeA.toString().equals(
                "A Shape with color of blue and Not filled");

        Shape shapeB = new Shape("orange", true);

        assert shapeB.getColor().equals("orange");
        assert shapeB.isFilled();

        shapeB.setColor("white");
        shapeB.setFilled(false);

        assert shapeB.getColor().equals("white");
        assert !shapeB.isFilled();

        Circle circleA = new Circle();

        assert circleA.getRadius() == 1.0;
        assert circleA.getColor().equals("green");
        assert circleA.isFilled();
        assert circleA.getArea() > 3.14;
        assert circleA.getPerimeter() > 6.28;
        assert circleA.toString().equals(
                "A Circle with radius=1.0, which is a subclass of "
                        + "A Shape with color of green and filled");

        circleA.setRadius(2.0);
        assert circleA.getRadius() == 2.0;
        assert circleA.getArea() > 12.56;
        assert circleA.getPerimeter() > 12.56;

        Circle circleB = new Circle(4.0);

        assert circleB.getRadius() == 4.0;
        assert circleB.getColor().equals("green");
        assert circleB.isFilled();

        Circle circleC = new Circle(3.0, "purple", false);

        assert circleC.getRadius() == 3.0;
        assert circleC.getColor().equals("purple");
        assert !circleC.isFilled();
        assert circleC.getArea() > 28.27;
        assert circleC.getPerimeter() > 18.84;
        assert circleC.toString().contains("A Circle with radius=3.0");

        Rectangle rectangleA = new Rectangle();

        assert rectangleA.getWidth() == 1.0;
        assert rectangleA.getLength() == 1.0;
        assert rectangleA.getColor().equals("green");
        assert rectangleA.isFilled();
        assert rectangleA.getArea() == 1.0;
        assert rectangleA.getPerimeter() == 4.0;
        assert rectangleA.toString().contains(
                "A Rectangle with width=1.0 and length=1.0");

        rectangleA.setWidth(3.0);
        rectangleA.setLength(5.0);

        assert rectangleA.getWidth() == 3.0;
        assert rectangleA.getLength() == 5.0;
        assert rectangleA.getArea() == 15.0;
        assert rectangleA.getPerimeter() == 16.0;

        Rectangle rectangleB = new Rectangle(4.0, 6.0);

        assert rectangleB.getWidth() == 4.0;
        assert rectangleB.getLength() == 6.0;
        assert rectangleB.getArea() == 24.0;
        assert rectangleB.getPerimeter() == 20.0;

        Rectangle rectangleC = new Rectangle(2.0, 7.0, "yellow", false);

        assert rectangleC.getWidth() == 2.0;
        assert rectangleC.getLength() == 7.0;
        assert rectangleC.getColor().equals("yellow");
        assert !rectangleC.isFilled();
        assert rectangleC.getArea() == 14.0;
        assert rectangleC.getPerimeter() == 18.0;
        assert rectangleC.toString().contains(
                "A Rectangle with width=2.0 and length=7.0");

        Square squareA = new Square();

        assert squareA.getSide() == 1.0;
        assert squareA.getWidth() == 1.0;
        assert squareA.getLength() == 1.0;
        assert squareA.getArea() == 1.0;
        assert squareA.getPerimeter() == 4.0;

        squareA.setSide(3.0);

        assert squareA.getSide() == 3.0;
        assert squareA.getWidth() == 3.0;
        assert squareA.getLength() == 3.0;
        assert squareA.getArea() == 9.0;
        assert squareA.getPerimeter() == 12.0;

        Square squareB = new Square(5.0);

        assert squareB.getSide() == 5.0;
        assert squareB.getArea() == 25.0;
        assert squareB.getPerimeter() == 20.0;

        Square squareC = new Square(6.0, "pink", true);

        assert squareC.getSide() == 6.0;
        assert squareC.getColor().equals("pink");
        assert squareC.isFilled();
        assert squareC.getArea() == 36.0;
        assert squareC.getPerimeter() == 24.0;
        assert squareC.toString().contains(
                "A Square with side=6.0");

        squareC.setWidth(8.0);

        assert squareC.getWidth() == 8.0;
        assert squareC.getLength() == 8.0;
        assert squareC.getArea() == 64.0;

        squareC.setLength(9.0);

        assert squareC.getWidth() == 9.0;
        assert squareC.getLength() == 9.0;
        assert squareC.getSide() == 9.0;
        assert squareC.getArea() == 81.0;
        assert squareC.getPerimeter() == 36.0;

        squareC.setSide(4.0);
        assert squareC.getWidth() == 4.0;
        assert squareC.getLength() == 4.0;

        System.out.println(shapeA);
        System.out.println(circleA);
        System.out.println(rectangleA);
        System.out.println(squareC);
        System.out.println("All shape tests passed!");
    }
}