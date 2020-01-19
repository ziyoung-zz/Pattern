package test;

public class PierrotExeuntCommand implements Command {

	Pierrot pierrot;
	
	public PierrotExeuntCommand(Pierrot pierrot){
		this.pierrot = pierrot;
	}
	
	@Override
	public void excute() {
		pierrot.exeunt();
	}
}
