package factoryPattern;

public class TenderDecorateFctory implements DecorateFactory {

	@Override
	public Color createColor() {
		return new GreenColor();
	}

	@Override
	public Texture createTexture() {
		return new SoftTexture();
	}

}
