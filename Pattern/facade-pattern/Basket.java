package test.facade;

import java.util.ArrayList;

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
