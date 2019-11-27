package alis.uwissu.psnluw.rissrnwl.online.pc;

public class FindOwnner {
	
	public RingOwnner findOwnner(String name){
		
		RingOwnner ownner = null;
		
		if("Hobbit".equals(name)){
			
			ownner = new Hobbit();
			
		}else if("Gollum".equals(name)){
			
			ownner = new Gollum();
		}
		
		System.out.print(name + "had a ring -> ");
		
		return ownner;
	}
	
}
