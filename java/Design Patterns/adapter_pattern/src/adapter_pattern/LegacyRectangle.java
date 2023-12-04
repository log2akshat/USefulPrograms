package adapter_pattern;

// Adaptee class
public class LegacyRectangle {
	private double length;
    private double width;

    public LegacyRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

}
