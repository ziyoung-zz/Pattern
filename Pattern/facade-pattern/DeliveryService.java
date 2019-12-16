package test.facade;

public class DeliveryService implements IDeliveryService {

	Basket basket = null;
	public DeliveryService(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void deliver() {
		System.out.println("====== delivery start======");
		System.out.println("addr is " + basket.addr);
		System.out.println("====== delivery end======");
	}

}
