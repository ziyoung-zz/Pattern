package factoryPattern;

public abstract class GeometricShape {
	String name;
	Color color;
	Texture texture;

	protected abstract void draw();
}
