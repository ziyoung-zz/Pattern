# facade Pattern
sub-system의 일련의 interface에 대한 통합 interface를 제공한다.
고수준 interface를 정의하기 때문에, sub-system을 더 쉽게 사용할 수 있다.
sub-system을 캡슐화하는것이 아니라 sub-system 기능을 사용할수 있는 interface를 제공하는것이기 때문에, sub-system의 클래스에 접근가능하다.

### 예제
쇼핑앱을 구현하였다.

장바구니 클래스
```java
public class Basket {
	ArrayList<String> orderList = new ArrayList<>();
	String addr = null;
	
	public void addBasket(String product){
		orderList.add(product);
	}
	
	public void showOrderList(){
		for(String product : orderList){
			System.out.println(product);
		}
	}
	
	public void setAddr(String addr){
		this.addr = addr;
	}
}
```
주문서비스
```java
public interface IOrderService {	
	void order();
	void setAddr(String addr);
}
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
```
패킹서비스
```java
public interface IPackingService {
	void packing();
}
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
```
배달서비스
```java
public interface IDeliveryService {
	void deliver();
}
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
```

세가지의 서비스를 제공하는 쇼핑서비스
```java
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
```
장바구니에 주문한 물품들을 주문,패킹,배달하는 서비스
```java
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
```
