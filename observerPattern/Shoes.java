package observarPattern;

import java.util.ArrayList;

public class Shoes implements Subject {

	private ArrayList<Observer> users = new ArrayList<Observer>();
	private boolean inStock = true;
	
	public void addObserver(Observer o) {
		users.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = users.indexOf(o);
		if(i > 0) {
			users.remove(i);
		}	
	}

	@Override
	public void notifyObservers() {
		for(Observer user : users) {
			user.update();
		}
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
		if(inStock) {
			notifyObservers(); 
		}
	}
}
