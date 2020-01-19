package test.statePattern;

public class NormalState implements State {

	@Override
	public void blink() {
		System.out.println("Normal blink");
	}

}
