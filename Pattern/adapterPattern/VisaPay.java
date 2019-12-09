package test.adapter;

public class VisaPay implements AppPay {

	@Override
	public void payWithApp() {
		System.out.println("pay with VisaPay");
	}

}
