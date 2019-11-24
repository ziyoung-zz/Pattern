package factoryPattern;

public class ToughDecorateFactory implements DecorateFactory {

	@Override
	public Color createColor() {
		return new RedColor();
	}

	@Override
	public Texture createTexture() {
		return new StiffTexture();
	}

}
