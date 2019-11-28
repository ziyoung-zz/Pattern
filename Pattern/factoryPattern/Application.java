package factoryPattern;

public class Application {

	public static void main(String[] args) {
		ShapeFactory toughFactory= new ToughShapeFactory();
		ShapeFactory tenderFactory = new TenderShapeFactory();
		
		GeometricShape line = toughFactory.createGeometricShape(ShapeType.LINE);
		line.draw();
		
		GeometricShape circle = tenderFactory.createGeometricShape(ShapeType.CIRCLE);
		circle.draw();
	}

}
