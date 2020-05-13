package observarPattern;

public class User implements Observer {

	private Subject shoes;
	
	public User(Subject shoes) {
		this.shoes = shoes;
		shoes.addObserver(this);
	}
	
	@Override
	public void update() {
		buyShoes();
		removeNotice();
	}
	
	public void buyShoes() {
		System.out.println("buy shoes");
	}
	
	public void removeNotice() {
		shoes.removeObserver(this);
	}

}
