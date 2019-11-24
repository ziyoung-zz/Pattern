package factoryPattern;

public class CircleShape extends GeometricShape {
	
	DecorateFactory decorateFactory;
	
	public CircleShape(DecorateFactory decorateFactory) {
		name = "Circle shape";
		this.decorateFactory = decorateFactory;
	}
	
	@Override
	protected void draw() {
		color = decorateFactory.createColor();
		texture = decorateFactory.createTexture();
		System.out.println("draw " + name);
		color.printColor();
		texture.printTexture();
	}
}
