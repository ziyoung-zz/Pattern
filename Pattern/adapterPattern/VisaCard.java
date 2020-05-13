package test.adapter;

public class VisaCard implements CreditCard {

	@Override
	public void pay() {
		System.out.println("pay with VisaCard");
	}

}
