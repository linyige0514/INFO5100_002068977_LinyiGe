package serialization;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Triangle(10, 5, 6, 7, 8),
            new Rectangle(10, 20),
            new Circle(7),
            new Square(5)
        );

        System.out.println("Before Serialization:");
        printAllShapes(shapes);

        // Serialize list
        String filename = "shapes.ser";
        serializeShapes(shapes, filename);

        // Change static field after serialization
        Shape.setColor("Green");

        // Deserialize list
        List<Shape> deserializedShapes = deserializeShapes(filename);

        System.out.println("\nAfter Deserialization:");
        printAllShapes(deserializedShapes);
    }

    private static void serializeShapes(List<Shape> shapes, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(shapes);
            System.out.println("✅ Shapes serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Shape> deserializeShapes(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Shape>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return List.of(); // return empty list if error
        }
    }

    private static void printAllShapes(List<Shape> shapes) {
        System.out.println("Color: " + Shape.getColor());
        System.out.println("=============================");
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getClass().getSimpleName());
            System.out.printf("Area: %.2f\n", shape.calculateArea());
            System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());
            System.out.println("-----------------------------");
        }
    }
}