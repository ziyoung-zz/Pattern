package decoratePattern;

public class PopcornStore {

	public static void main(String[] args) {

		System.out.println("팝콘가게가 열었습니다.");
		System.out.println("우리의가장 기본메뉴 입니다.");
		
		FoodCort foodCort = new OriginalCombo();
		foodCort.menu();
		
		System.out.println("\n장사가 잘되어 새 메뉴들을 추가하였습니다.");
		System.out.println("새메뉴들 입니다.");
		
		FoodCort pretzelCombo = new PretzelCombo(new OriginalCombo());
		FoodCort sausageCombo = new SausageCombo(new OriginalCombo());
		
		pretzelCombo.menu();
		sausageCombo.menu();
	}

}
