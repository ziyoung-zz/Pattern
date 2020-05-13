package decoratePattern;

public class DecorateFoodCort extends FoodCort {

	FoodCort foodCort;
	
	public DecorateFoodCort(FoodCort foodCort) {
		this.foodCort = foodCort;
	}
	
	@Override
	public void menu() {
		foodCort.menu();
	}

}
