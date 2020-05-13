package factoryPattern;

public class LineShape extends GeometricShape {
	
	DecorateFactory decorateFactory;
	
	public LineShape(DecorateFactory decorateFactory) {
		name = "Line shape";
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
