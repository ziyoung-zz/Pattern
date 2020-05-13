package factoryPattern;

public abstract class ShapeFactory {
	
	public GeometricShape drawShape(ShapeType shapeType) {
		
		GeometricShape shape;
		shape = this.createGeometricShape(shapeType);
		shape.draw();
		
		return shape;
	}
	
	protected abstract GeometricShape createGeometricShape(ShapeType line);
	
}


