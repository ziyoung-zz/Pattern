package test;

public class JugglerEnterCommand implements Command {

	Juggler juggler;
	
	public JugglerEnterCommand(Juggler juggler){
		this.juggler = juggler;
	}
	
	@Override
	public void excute() {
		juggler.enter();
		juggler.juggle();
	}

}
