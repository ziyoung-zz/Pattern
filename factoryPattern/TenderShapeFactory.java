package factoryPattern;

public class TenderShapeFactory extends ShapeFactory {

	@Override
	protected GeometricShape createGeometricShape(ShapeType shapeType) {
		GeometricShape shape = null;
		DecorateFactory decorateFactory = new TenderDecorateFctory();
		
		switch(shapeType) {
			case LINE:
				shape = new LineShape(decorateFactory);
				break;
			case CIRCLE:
				shape = new CircleShape(decorateFactory);
				break;				
		}
		return shape;
	}

}
