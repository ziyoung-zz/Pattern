package alis.uwissu.psnluw.rissrnwl.online.pc;

public class Hobbit extends RingOwnner {

	@Override
	public void ownTheRing() {
		TheOneRing ring = TheOneRing.getTheOneRing();
		ring.setStatus(true);
		ring.printRingStaus();
	}

}
