package templateMethodPattern;

public class TempWorld {

	public static void main(String[] args) {
		
		//�л��� �Ͼ��,��԰�,�����ϰ�,��ϴ�.
		Student student = new Student();
		student.dailyRoutine();
		
		//�������� �Ͼ��,��԰�,���ϰ�,��ϴ�.
		Worker worker = new Worker();
		worker.dailyRoutine();
		
		//�ǹ��ִ� �Ͼ��,��԰�,�ǹ������ϰ�,�����ð��̳����� �䰡���ϰ�,��ϴ�.
		LandLord landlord = new LandLord();
		landlord.dailyRoutine();
	}
}
