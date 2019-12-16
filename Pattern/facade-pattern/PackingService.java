package test.facade;

public class PackingService implements IPackingService {
	
	Basket basket = null;
	
	public PackingService(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void packing() {
		System.out.println("======= packing start======");
		basket.showOrderList();
		System.out.println("======= packing end======");
	}

}
