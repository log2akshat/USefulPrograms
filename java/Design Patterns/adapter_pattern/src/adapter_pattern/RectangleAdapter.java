package adapter_pattern;

// Adapter class
public class RectangleAdapter implements Rectangle {
	private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public double computeArea() {
        return legacyRectangle.calculateArea();
    }

}
