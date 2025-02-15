// Abstract base class
abstract class Shape {
    protected static String color = "Blue";  // Static field shared by all shapes

    // Abstract methods to be implemented by subclasses
    abstract double calculateArea();
    abstract double calculatePerimeter();

    // Static method to change color
    public static void setColor(String newColor) {
        color = newColor;
    }

    // Method to get color
    public static String getColor() {
        return color;
    }
}

// Derived class: Triangle
class Triangle extends Shape {
    private double base, height, sideA, sideB, sideC;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}

// Derived class: Rectangle
class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Derived class: Circle
class Circle extends Shape {
    private double radius;
    private static final double PI = 3.14159; // Static constant for PI

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * PI * radius;
    }
}

// Derived class: Square (inherits from Rectangle)
class Square extends Rectangle {
    public Square(double side) {
        super(side, side); // Square has equal sides
    }
}

// Main class to demonstrate concepts
public class Exercise2 {
    public static void main(String[] args) {
        // Creating objects
        Shape triangle = new Triangle(10, 5, 6, 7, 8);
        Shape rectangle = new Rectangle(10, 20);
        Shape circle = new Circle(7);
        Shape square = new Square(5);

        // Displaying color (static field)
        System.out.println("Initial color of shapes: " + Shape.getColor());

        // Displaying area and perimeter of each shape using polymorphism
        displayShapeDetails(triangle);
        displayShapeDetails(rectangle);
        displayShapeDetails(circle);
        displayShapeDetails(square);

        // Changing static color
        Shape.setColor("Red");
        System.out.println("\nUpdated color of shapes: " + Shape.getColor());
    }

    // Polymorphic method to display details of any shape
    public static void displayShapeDetails(Shape shape) {
        System.out.println("Shape: " + shape.getClass().getSimpleName());
        System.out.println("Color: " + Shape.getColor());
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println("----------------------");
    }
}