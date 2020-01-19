package templateMethodPattern;

public abstract class Person {

	void dailyRoutine() {
		wakeUp();
		eatMeal();
		doMyWork();
		if(isFreeTime()) {
			doHobby();
		}
		goToBed();
	}
	
	abstract void doMyWork();
	
	final void wakeUp() {
		System.out.println("wake up in the morning");	
	}
	
	final void eatMeal() {
		System.out.println("eat delicious meal");
	}
	
	final void goToBed() {
		System.out.println("go to bed");
	}
	
	boolean isFreeTime() {
		return false;
	}
	
	void doHobby() {
	}
}
