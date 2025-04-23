package serialization;

public abstract class Shape {
    protected static String color = "Blue";  // Shared static field

    public static void setColor(String newColor) {
        color = newColor;
    }

    public static String getColor() {
        return color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}