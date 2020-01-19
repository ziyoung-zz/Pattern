package test.facade;

public class ShoppingApp {

	private IOrderService orderService;
	private IPackingService packingService;
	private IDeliveryService deliveryService;
	
	public ShoppingApp(IOrderService orderService, IPackingService packingService, IDeliveryService deliveryService) {
		this.orderService = orderService;
		this.packingService = packingService;
		this.deliveryService = deliveryService;
	}
	
	public void QuickOrder(String addr){
		orderService.setAddr(addr);
		orderService.order();
		packingService.packing();
		deliveryService.deliver();
	}
}
