package LAB5.Q18_Pizza;

public class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.round(Math.PI * radius * radius * 100.0) / 100.0;
    }
}