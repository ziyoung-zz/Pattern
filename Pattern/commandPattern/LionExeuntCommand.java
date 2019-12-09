package test;

public class LionExeuntCommand implements Command {

	Lion lion;
	
	public LionExeuntCommand(Lion lion){
		this.lion = lion;
	}
	
	@Override
	public void excute() {
		lion.exeunt();
	}
}
