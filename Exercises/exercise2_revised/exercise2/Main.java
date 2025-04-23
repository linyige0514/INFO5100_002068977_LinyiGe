package exercise2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create different shapes using polymorphism
        List<Shape> shapes = List.of(
            new Triangle(10, 5, 6, 7, 8),
            new Rectangle(10, 20),
            new Circle(7),
            new Square(5)
        );

        System.out.println("Initial color of all shapes: " + Shape.getColor());
        System.out.println("====================================");

        for (Shape shape : shapes) {
            displayShapeDetails(shape);
        }

        // Change the shared static color
        Shape.setColor("Red");
        System.out.println("Updated color of all shapes: " + Shape.getColor());
        System.out.println("====================================");

        for (Shape shape : shapes) {
            displayShapeDetails(shape);
        }
    }

    // Polymorphic method
    public static void displayShapeDetails(Shape shape) {
        System.out.println("Shape: " + shape.getClass().getSimpleName());
        System.out.println("Color: " + Shape.getColor());
        System.out.printf("Area: %.2f\n", shape.calculateArea());
        System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());
        System.out.println("------------------------------------");
    }
}
