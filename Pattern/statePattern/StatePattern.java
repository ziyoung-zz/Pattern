package test.statePattern;

public class StatePattern {

	public static void main(String[] args) {
		Cyclops cyclops = new Cyclops();		
		cyclops.blink();
		cyclops.setState("BATTLE");
		cyclops.blink();
		cyclops.setState("NORMAL");
		cyclops.blink();
	}
}
