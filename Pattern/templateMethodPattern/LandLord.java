package templateMethodPattern;

public class LandLord extends Person {

	@Override
	void doMyWork() {
		System.out.println("I'm managing my buliding");
	}
	@Override
	boolean isFreeTime() {
		return true;
	}
	@Override
	void doHobby() {
		System.out.println("I do yoga");
	}
}
