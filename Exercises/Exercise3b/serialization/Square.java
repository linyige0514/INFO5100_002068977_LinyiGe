package serialization;

public class Square extends Rectangle {
    private static final long serialVersionUID = 3L;

    public Square(double side) {
        super(side, side);
    }
}