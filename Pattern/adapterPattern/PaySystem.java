package test.adapter;

public class PaySystem {

	public static void main(String[] args) {
		
		VisaCard card = new VisaCard();
		VisaPay appCard = new VisaPay();
		
		card.pay();
		appCard.payWithApp();
		
		AppCardAdapter appCardAdapter = new AppCardAdapter(card);
		appCardAdapter.payWithApp();
		
	}

}
