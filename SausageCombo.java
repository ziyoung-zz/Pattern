package decoratePattern;

public class SausageCombo extends DecorateFoodCort {

	public SausageCombo(FoodCort foodCort) {
		super(foodCort);
		// TODO Auto-generated constructor stub
	}

	public void menu() {
		super.menu();
		addSausage();
	}
	public void addSausage() {
		System.out.println(",¼Ò¼¼Áö");
	}
}
