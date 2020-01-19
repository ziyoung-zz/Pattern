package templateMethodPattern;

public class TempWorld {

	public static void main(String[] args) {
		
		//학생은 일어나고,밥먹고,공부하고,잡니다.
		Student student = new Student();
		student.dailyRoutine();
		
		//직장인은 일어나고,밥먹고,일하고,잡니다.
		Worker worker = new Worker();
		worker.dailyRoutine();
		
		//건물주는 일어나고,밥먹고,건물관리하고,여가시간이남으면 요가를하고,잡니다.
		LandLord landlord = new LandLord();
		landlord.dailyRoutine();
	}
}
