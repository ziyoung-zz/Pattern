package test;

public class LionEnterCommand implements Command {

	Lion lion;
	
	public LionEnterCommand(Lion lion){
		this.lion = lion;
	}
	
	@Override
	public void excute() {
		lion.enter();
		lion.roar();
	}
}
