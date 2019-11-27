package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LoardOfRing {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			
			public void run(){
				
				System.out.println("An age of confusion END");
				
				System.exit(0);
			}
		};
		
		timer.schedule(task, 40);
		
		System.out.println("An age of confusion START");
		FindOwnner findOwnner = new FindOwnner();
		RingOwnner ringOwnner = null;
		Random random = new Random();
		
		while(true){
			
			if(random.nextBoolean()){
				ringOwnner = findOwnner.findOwnner("Hobbit");
			}else{
				ringOwnner = findOwnner.findOwnner("Gollum");
			}
			ringOwnner.ownTheRing();
		}
		
	}
	
	/*
	 * 싱글턴예제 
	 * :혼돈의 시대에 반지의 주인이 누가 될것인가
	 * :반지는 하나 존재하고, 주인은 계속 바뀔수 있다.
	 * 
	 * 
	 * test
	 * 
	 * An age of confusion START
		Gollumhad a ring -> THE ONE RING STATUS :: false
		Hobbithad a ring -> THE ONE RING STATUS :: true
		Gollumhad a ring -> THE ONE RING STATUS :: false
		Hobbithad a ring -> THE ONE RING STATUS :: true		
	   An age of confusion END   
	 */

}
