package test;

public class PierrotEnterCommand implements Command {

	Pierrot pierrot;
	
	public PierrotEnterCommand(Pierrot pierrot){
		this.pierrot = pierrot;
	}
	
	@Override
	public void excute() {
		pierrot.enter();
		pierrot.perform();
	}
}
