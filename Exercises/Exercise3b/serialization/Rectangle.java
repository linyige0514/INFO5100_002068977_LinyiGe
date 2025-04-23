package serialization;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {
    private static final long serialVersionUID = 2L;

    private final double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}