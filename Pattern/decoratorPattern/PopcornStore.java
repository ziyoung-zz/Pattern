package decoratePattern;

public class PopcornStore {

	public static void main(String[] args) {

		System.out.println("���ܰ��԰� �������ϴ�.");
		System.out.println("�츮�ǰ��� �⺻�޴� �Դϴ�.");
		
		FoodCort foodCort = new OriginalCombo();
		foodCort.menu();
		
		System.out.println("\n��簡 �ߵǾ� �� �޴����� �߰��Ͽ����ϴ�.");
		System.out.println("���޴��� �Դϴ�.");
		
		FoodCort pretzelCombo = new PretzelCombo(new OriginalCombo());
		FoodCort sausageCombo = new SausageCombo(new OriginalCombo());
		
		pretzelCombo.menu();
		sausageCombo.menu();
	}

}
