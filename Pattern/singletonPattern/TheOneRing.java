package alis.uwissu.psnluw.rissrnwl.online.pc;

public class TheOneRing {

	public static TheOneRing ring = null;
	private boolean status;
	
	public static TheOneRing getTheOneRing(){
		if(ring == null){
			ring = new TheOneRing();
		}		
		return ring;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public void printRingStaus(){
		System.out.println("THE ONE RING STATUS :: " + this.status);
	}
	
}
