
package test.facade;

public class OrderService implements IOrderService {

	Basket basket = null;
	
	public OrderService(Basket basket){
		this.basket = basket;
	}
	
	@Override
	public void order() {
		System.out.println("=====ordering start=======");
		basket.showOrderList();
		System.out.println("addr : " + basket.addr);
		System.out.println("=====ordering end=======");
	}

	@Override
	public void setAddr(String addr) {
		basket.setAddr(addr);
	}

	
}
