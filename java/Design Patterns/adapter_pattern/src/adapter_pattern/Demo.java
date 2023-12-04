package adapter_pattern;

public class Demo {
	public static void main(String[] args) {
		// Using the LegacyRectangle in the context of Rectangle interface
		LegacyRectangle legacyRectangle = new LegacyRectangle(50, 100);
		Rectangle rectangleAdapter = new RectangleAdapter(legacyRectangle);

		// Client interacts with the Target interface
		double area = rectangleAdapter.computeArea();
		System.out.println("Area: " + area);
	}
}
