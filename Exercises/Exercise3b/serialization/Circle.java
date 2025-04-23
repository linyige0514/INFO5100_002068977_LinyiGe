package serialization;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {
    private static final long serialVersionUID = 4L;

    private final double radius;
    private static final double PI = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}