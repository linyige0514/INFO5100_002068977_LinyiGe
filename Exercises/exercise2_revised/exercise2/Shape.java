package exercise2;

public abstract class Shape {
    protected static String color = "Blue";  // static field shared across all shapes

    public static void setColor(String newColor) {
        color = newColor;
    }

    public static String getColor() {
        return color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
