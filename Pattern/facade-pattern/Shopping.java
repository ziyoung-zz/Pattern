package test.facade;

public class Shopping {

	public static void main(String[] args) {
		
		Basket basket = new Basket();
		basket.addBasket("water");
		basket.addBasket("apple");
		basket.addBasket("beer");
		
		OrderService orderService = new OrderService(basket);
		PackingService packingService = new PackingService(basket);
		DeliveryService deliveryService = new DeliveryService(basket);
		
		ShoppingApp coupang = new ShoppingApp(orderService, packingService, deliveryService);
		coupang.QuickOrder("seoul 123-123");
		
	}
}
