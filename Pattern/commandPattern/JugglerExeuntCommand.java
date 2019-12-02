package test;

public class JugglerExeuntCommand implements Command {
	Juggler juggler;
	
	public JugglerExeuntCommand(Juggler juggler){
		this.juggler = juggler;
	}
	
	@Override
	public void excute() {
		juggler.exeunt();
	}
}
