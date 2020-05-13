package test.adapter;

public class AppCardAdapter implements AppPay {

	CreditCard creditCard;
	
	public AppCardAdapter(CreditCard creditCard){
		this.creditCard = creditCard;
	}
	
	@Override
	public void payWithApp() {
		creditCard.pay();
	}

}
