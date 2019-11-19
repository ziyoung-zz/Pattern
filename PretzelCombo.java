package decoratePattern;

public class PretzelCombo extends DecorateFoodCort {

	public PretzelCombo(FoodCort foodCort) {
		super(foodCort);
		
	}
	
	public void menu() {
		super.menu();
		addPretzel();
	}

	public void addPretzel() {
		System.out.println(",ÇÁ·¹Ãú");
	}
}
